package com.Networking;
import java.io.IOException;
import java.net.*;
import java.io.InputStream;
import java.io.FileOutputStream;

/* Написать Java программу, которое загружает изображение из Интернета и сохраняет в локальную папку */

public class Networking {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://zvukobook.ru/800/600/https/toghr.com/wp-content/uploads/2020/04/171.png");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        InputStream in = null;
        FileOutputStream out = null;

        try {
            in = con.getInputStream();
            out = new FileOutputStream("E:\\DOKU\\Java\\Streams\\image.png");
            int length;

            while ((length = in.read()) != -1)
            {
                out.write(length);
            }
        }
        finally {
            if (in != null) {
                in.close();  // оба потока должны быть закрыты
            }
            if (out != null) {
                out.close();
            }

            con.disconnect();
        }
    }
}
