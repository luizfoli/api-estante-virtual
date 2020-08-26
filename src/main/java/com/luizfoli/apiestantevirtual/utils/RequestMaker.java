package com.luizfoli.apiestantevirtual.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Service;

@Service
public class RequestMaker {

    public JSONObject get(String urlPath) {
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(urlPath).openConnection();
            con.setRequestMethod("GET");
            con.connect();
            BufferedReader response = new BufferedReader(new InputStreamReader(con.getInputStream()));
            return new JSONObject(new JSONTokener(response));
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            return null;
        }
    }
};