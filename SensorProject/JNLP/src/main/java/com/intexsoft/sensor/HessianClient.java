package com.intexsoft.sensor;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

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

    public void sendData()  {
        User user = new User("qwe", "qwerty");
        Gson gson = new Gson();
        String jsonData = gson.toJson(user);

        HttpClient httpClient = new DefaultHttpClient();

        try {
            HttpPost request = new HttpPost("http://localhost:8080/service/api/sendData");
//            StringEntity params =new StringEntity("details={\"name\":\"myname\",\"age\":\"20\"} ");
            StringEntity params =new StringEntity(jsonData);
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);

            // handle response here...
        }catch (Exception ex) {
            // handle exception here
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }

    public class User   {
        String password;
        String userName;

        public User(String password, String userName) {
            this.password = password;
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
