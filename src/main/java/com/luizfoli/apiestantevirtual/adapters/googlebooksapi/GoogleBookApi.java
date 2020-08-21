package com.luizfoli.apiestantevirtual.adapters.googlebooksapi;

import org.springframework.stereotype.Service;

import org.json.JSONArray;
import org.json.JSONObject;

@Service
public class GoogleBookApi {

    public JSONArray convertJsonToItems(JSONObject json) {
        return json.getJSONArray("items");
    }

}