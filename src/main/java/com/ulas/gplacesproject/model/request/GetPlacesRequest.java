package com.ulas.gplacesproject.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetPlacesRequest {
    private double latitude;
    private double longitude;
    private double radius;
}
