package com.ulas.gplacesproject.interfaces.controller;

import com.ulas.gplacesproject.interfaces.controller.common.BaseController;
import com.ulas.gplacesproject.interfaces.service.PlaceService;
import com.ulas.gplacesproject.model.request.GetPlacesRequest;
import com.ulas.gplacesproject.model.response.PlaceResponse;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@Api(value = "PlaceController", tags = "PlaceController")
public interface PlaceController extends BaseController<PlaceService> {

    @GetMapping("/getPlaces")
    ResponseEntity<PlaceResponse> getAllPlaces(GetPlacesRequest getPlacesRequest);
}
