package com.ulas.gplacesproject.interfaces.service;

import com.ulas.gplacesproject.model.request.GetPlacesRequest;
import com.ulas.gplacesproject.model.response.PlaceResponse;

public interface PlaceService {
    PlaceResponse getPlaces(GetPlacesRequest getPlacesRequest);
}
