package com.Networking;
import java.io.IOException;
import java.net.*;
import java.io.InputStream;
import java.io.FileOutputStream;

/* Написать Java программу, которое загружает изображение из Интернета и сохраняет в локальную папку */

public class Networking {
    public static void main(String s[]) throws IOException {

        URL url = new URL("https://zvukobook.ru/800/600/https/toghr.com/wp-content/uploads/2020/04/171.png");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        InputStream in = con.getInputStream();
        FileOutputStream out = new FileOutputStream("E:\\DOKU\\Java\\Streams\\image.png");

        byte[] buffer = new byte[1024];
        int length;

        while ((length = in.read(buffer)) != -1)
        {
            out.write(buffer, 0, length);
        }
        out.close();
        in.close();
        con.disconnect();
    }

}
