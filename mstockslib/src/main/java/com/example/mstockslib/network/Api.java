package com.example.mstockslib.network;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Api {
    public <T> T get(String urlString, Class<T> classT) throws Exception {
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        Gson g = new Gson();
        return g.fromJson(reader, classT);
    }
}
