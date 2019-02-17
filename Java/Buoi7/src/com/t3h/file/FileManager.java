package com.t3h.file;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileManager {
    private String path = "D:/T3H/Android/1810/a.txt";

    public void management() {
        File file = new File(path);
        if (file.exists()) {
            String pathRename = "D:/T3H/Android/1810/b.txt";
            file.renameTo(new File(pathRename));
        } else {
            try {
                file.getParentFile().mkdirs();
                boolean created = file.createNewFile();
                System.out.println(created);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readAllFile(File file) {
        try {
            if (file.isFile()) {
                System.out.println("===================");
                System.out.println(file.getName());
                System.out.println(file.length());
                // format time
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm aaa");
                Date date = new Date(file.lastModified());
                String lastModified = format.format(date);
                // format time
                System.out.println(lastModified);
                return;
            }
            for (File f : file.listFiles()) {
                readAllFile(f);
            }
        } catch (Exception ex) {

        }
    }

    public void write(String s) {
        try {
            File file = new File(path);
            if (file.exists() == false) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            FileOutputStream outputStream =
                    new FileOutputStream(file, true);
            outputStream.write(s.getBytes());
            outputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void read() {
        File file = new File(path);
        if (file.exists() == false) {
            System.out.println("File chua ton tai");
            return;
        }
        try {
            FileInputStream inputStream = new FileInputStream(file);
            byte[] b = new byte[1024];
            int count = inputStream.read(b);
            StringBuilder builder = new StringBuilder();
            while (count != -1) {
                String s = new String(b, 0, count);
                builder.append(s);
                count = inputStream.read(b);
            }
            inputStream.close();
            System.out.println(builder);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void downloadFile(String link, String fileName) {
        try {
            // file target
            File file = new File("D:/T3H/Download/" + fileName);
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileOutputStream outputStream
                    = new FileOutputStream(file, false);
            // file source
            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            long total = connection.getContentLengthLong();
            InputStream inputStream = connection.getInputStream();
            // Save file
            long totalSaved = 0;
            byte[] b = new byte[2048];
            int count = inputStream.read(b);
            while (count != -1) {
                outputStream.write(b, 0, count);
                totalSaved += count;
                int percent = (int) (totalSaved * 100 / total);
                System.out.println(percent);
                count = inputStream.read(b);
            }
            inputStream.close();
            outputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
