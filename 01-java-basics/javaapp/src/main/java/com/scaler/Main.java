package com.scaler;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Main {
    static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Person p1 = Person.builder().age(25).name("John Doe").build();
        Person p2 = Person.builder().age(25).name("John Doe").build();
        System.out.println(p1.toString());
        System.out.println(p2.toString());

        System.out.println(p1.equals(p2));   // ?1 true
        System.out.println(p1 == p2);        // ?2 false

        try {
            System.out.println(getUrl("http://example.com/"));
        } catch (IOException e) {
            System.err.println(e);
        }

    }

    static String getUrl(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}