package com.phongbm.musicplayer.dao;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.phongbm.musicplayer.model.FieldInfo;
import com.phongbm.musicplayer.model.MP3Media;
import com.phongbm.musicplayer.model.Song;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class SystemData {
    private ContentResolver resolver;

    public SystemData(Context context) {
        resolver = context.getContentResolver();
    }

    public ArrayList<Song> getSongs(){
        Cursor cursor = resolver.query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, null, null, null, null);
        ArrayList<Song> arr = getData(cursor, Song.class);
        return arr;
    }

    private  <T extends MP3Media> ArrayList<T> getData(Cursor cursor, Class<T> clz) {
        ArrayList<T> arr = new ArrayList<>();
        try {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                // tạo ra đối tượng bằng cách gọi constructor rỗng
                T t = clz.newInstance();
                // lấy toàn bộ thuộc tính của đối tượng
                Field[] fields = clz.getDeclaredFields();

                for (Field f : fields) {
                    // lấy annotation của trường
                    FieldInfo info = f.getAnnotation(FieldInfo.class);
                    // nếu k có annotation thì đọc sang field tiếp theo
                    if (info == null) continue;
                    // lấy dữ liệu từ database
                    int index = cursor.getColumnIndex(info.fieldName());
                    String value = cursor.getString(index);
                    // set dữ liệu vào cho object
                    setData(f, t, value);
                }
                arr.add(t);
                cursor.moveToNext();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return arr;
    }

    private <T extends MP3Media> void setData(Field f, T t, String value) throws IllegalAccessException {
        f.setAccessible(true);
        // lấy ra kiểu dữ liệu của thuộc tính
        String typeName = f.getType().getSimpleName();

        if (typeName.equalsIgnoreCase("int")){
            f.setInt(t, Integer.parseInt(value));
            return;
        }
        if (typeName.equalsIgnoreCase("long")){
            f.setLong(t, Long.parseLong(value));
            return;
        }
        if (typeName.equalsIgnoreCase("float")){
            f.setFloat(t, Float.parseFloat(value));
            return;
        }
        if (typeName.equalsIgnoreCase("double")){
            f.setDouble(t, Double.parseDouble(value));
            return;
        }
        if (typeName.equalsIgnoreCase("boolean")){
            f.setBoolean(t, Boolean.parseBoolean(value));
            return;
        }
        // set cho kiểu dữ liệu đối tượng
        f.set(t, value);
    }
}
