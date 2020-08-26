package com.luizfoli.apiestantevirtual.adapters.googlebooksapi;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.luizfoli.apiestantevirtual.adapters.googlebooksapi.models.VolumeGoogleBookApi;
import com.luizfoli.apiestantevirtual.utils.JsonUtil;

import org.json.JSONArray;
import org.json.JSONObject;

@Service
public class GoogleBookApi {

    private JsonUtil jsonUtil;

    public GoogleBookApi(JsonUtil jsonUtil) {
        this.jsonUtil = jsonUtil;
    }

    public List<VolumeGoogleBookApi> convertJsonToVolumes(JSONObject json) {

        List<VolumeGoogleBookApi> volumes = new ArrayList<>();

        if (json.has("items")) {
            JSONArray items = json.getJSONArray("items");
            items.forEach(item -> {
                VolumeGoogleBookApi volume = new VolumeGoogleBookApi();
                volume.setId(jsonUtil.getStringIfHas(((JSONObject) item), "id"));

                if (((JSONObject) item).has("volumeInfo")) {
                    JSONObject volumeInfo = jsonUtil.getObjectIfHas(((JSONObject) item), "volumeInfo");

                    volume.setTitle(jsonUtil.getStringIfHas(volumeInfo, "title"));
                    volume.setPublisher(jsonUtil.getStringIfHas(volumeInfo, "publisher"));
                    volume.setPublishedDate(jsonUtil.getStringIfHas(volumeInfo, "publishedDate"));
                    volume.setDescription(jsonUtil.getStringIfHas(volumeInfo, "description"));
                    volume.setPageCount(jsonUtil.getIntIfHas(volumeInfo, "pageCount"));
                    volume.setAverageRating(jsonUtil.getIntIfHas(volumeInfo, "averageRating"));
                    volume.setRatingCount(jsonUtil.getIntIfHas(volumeInfo, "ratingCount"));
                    volume.setImageLink(jsonUtil.getStringIfHas(volumeInfo, "imageLink"));
                }

                volumes.add(volume);
            });
        }

        return volumes;
    }
}