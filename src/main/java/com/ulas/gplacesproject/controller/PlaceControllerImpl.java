package com.ulas.gplacesproject.controller;

import com.ulas.gplacesproject.interfaces.controller.PlaceController;
import com.ulas.gplacesproject.interfaces.service.PlaceService;
import com.ulas.gplacesproject.model.request.GetPlacesRequest;
import com.ulas.gplacesproject.model.response.PlaceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PlaceControllerImpl implements PlaceController {

    private final PlaceService placeService;

    @Override
    public PlaceService getService() {
        return placeService;
    }

    @Override
    public ResponseEntity<PlaceResponse> getAllPlaces(GetPlacesRequest getPlacesRequest) {
        return ResponseEntity.ok(getService().getPlaces(getPlacesRequest));
    }
}
