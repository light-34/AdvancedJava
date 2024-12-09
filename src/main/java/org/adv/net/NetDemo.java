package org.adv.net;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class NetDemo {
    public static void main(String[] args) throws Exception{
        String image = "https://www.google.com/images/branding/google_logo.png";
        URL url = new URL(image);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        System.out.println("Response Code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try(InputStream in = conn.getInputStream()) {
                Files.copy(in, Paths.get("google_logo.png"), StandardCopyOption.REPLACE_EXISTING);
            }
        } else {
            System.out.println("Failed to fetch google logo");
        }
    }
}
