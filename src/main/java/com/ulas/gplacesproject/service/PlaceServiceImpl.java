package com.ulas.gplacesproject.service;

import com.google.gson.Gson;
import com.mongodb.client.MongoDatabase;
import com.ulas.gplacesproject.interfaces.mapper.PlaceMapper;
import com.ulas.gplacesproject.interfaces.repository.PlaceRepository;
import com.ulas.gplacesproject.interfaces.service.PlaceService;
import com.ulas.gplacesproject.model.entity.PlaceEntity;
import com.ulas.gplacesproject.model.request.GetPlacesRequest;
import com.ulas.gplacesproject.model.response.PlaceResponse;
import com.ulas.gplacesproject.properties.ApiProperties;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceMapper placeMapper;
    private final PlaceRepository placeRepository;
    private final MongoDatabase mongoDatabase;
    private final ApiProperties apiProperties;

    private static String setUrl(ApiProperties apiProperties, GetPlacesRequest getPlacesRequest) {
        return apiProperties.getPlaceApiUrl() + "location=" + getPlacesRequest.getLatitude() + ","
                + getPlacesRequest.getLongitude() + "&" + "radius=" + getPlacesRequest.getRadius()
                + "&key=" + apiProperties.getApiKey();
    }

    @Override
    public PlaceResponse getPlaces(GetPlacesRequest getPlacesRequest) {
        PlaceEntity placeEntity = placeRepository.findByLatLongRadius(getPlacesRequest, mongoDatabase);

        if (placeEntity == null) {
            Response response = getPlacesByApi(getPlacesRequest);
            JSONObject json = prepareJsonResponse(response);
            placeEntity = preparePlaceEntity(json, getPlacesRequest);
            placeRepository.save(placeEntity);
        }

        return placeMapper.toResponse(placeEntity);
    }

    @SneakyThrows
    private Response getPlacesByApi(GetPlacesRequest getPlacesRequest) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(setUrl(apiProperties, getPlacesRequest))
                .method("GET", null)
                .build();
        return client.newCall(request).execute();
    }

    @SneakyThrows
    private JSONObject prepareJsonResponse(Response response) {
        JSONParser parser = new JSONParser(JSONParser.MODE_PERMISSIVE);
        return (JSONObject) parser.parse(response.body().string());
    }

    private PlaceEntity preparePlaceEntity(JSONObject json, GetPlacesRequest getPlacesRequest) {
        PlaceEntity placeEntity = new Gson().fromJson(json.toJSONString(), PlaceEntity.class);
        placeEntity.setLatitude(getPlacesRequest.getLatitude());
        placeEntity.setLongitude(getPlacesRequest.getLongitude());
        placeEntity.setRadius(getPlacesRequest.getRadius());
        return placeEntity;
    }
}
