package com.luizfoli.apiestantevirtual.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;
import org.json.JSONTokener;

public class RequestMaker {

    public JSONObject get(String urlPath) {

        try {
            URL url = new URL(urlPath);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            BufferedReader response = new BufferedReader(new InputStreamReader(con.getInputStream()));
            JSONTokener tokener = new JSONTokener(response);
            JSONObject json = new JSONObject(tokener);

            return json;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

};