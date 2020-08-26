package com.luizfoli.apiestantevirtual.utils;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class JsonUtil {

    public JSONObject getObjectIfHas(JSONObject json, String key) {
        return (json.has(key)) ? json.getJSONObject(key) : null;
    }

    public String getStringIfHas(JSONObject json, String key) {
        return (json.has(key)) ? json.getString(key) : "";
    }

    public int getIntIfHas(JSONObject json, String key) {
        return (json.has(key)) ? json.getInt(key) : 0;
    }

}