package com.phongbm.buoi13;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.phongbm.buoi13.model.Song;

import java.util.ArrayList;

// contact
//ContactsContract.Data.CONTENT_URI
// callog
// CallLog.CONTENT_URI
// Sms
//Telephony.Sms.CONTENT_URI
// Image
// MediaStore.Images.Media.EXTERNAL_CONTENT_URI
// Video
// MediaStore.Video.Media.EXTERNAL_CONTENT_URI
// Audio
// MediaStore.Audio.Media.EXTERNAL_CONTENT_URI

public class SystemData {
    private ContentResolver resolver;

    public SystemData(Context context) {
        resolver = context.getContentResolver();
    }

    //MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
    //MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI
    //MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI

    public ArrayList<Song> getData() {
        ArrayList<Song> arr = new ArrayList<>();

        Cursor cursor = resolver.query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                null, null, null, null);

        cursor.moveToFirst();
        int indexData = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DATA);
        int indexTitle = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.TITLE);
        int indexDuration = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DURATION);
        int indexSize = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.SIZE);
        int indexAlbum = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ALBUM);
        int indexArtist = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ARTIST);
        while (cursor.isAfterLast() == false) {
//            for (int i = 0; i < cursor.getColumnCount(); i++) {
//                Log.e(cursor.getColumnName(i), cursor.getString(i)+"");
//            }
//            Log.e("===========", "===============");
            String data = cursor.getString(indexData);
            String title = cursor.getString(indexTitle);
            long duration = cursor.getLong(indexDuration);
            long size = cursor.getLong(indexSize);
            String album = cursor.getString(indexAlbum);
            String artist = cursor.getString(indexArtist);

            Song song = new Song(data, duration, size, title, album, artist);
            arr.add(song);
            cursor.moveToNext();
        }
        return arr;
    }
}
