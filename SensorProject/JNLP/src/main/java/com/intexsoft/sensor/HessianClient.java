package com.intexsoft.sensor;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * User: sergey.berdashkevich
 * Date: 02.08.13
 */
public class HessianClient {

    private String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    public String getData() throws Exception {

        String jsonData = readUrl("http://localhost:8080/service/api/getData");
        Gson gson = new Gson();
        String message = gson.fromJson(jsonData, String.class);

        return message;
    }
}
