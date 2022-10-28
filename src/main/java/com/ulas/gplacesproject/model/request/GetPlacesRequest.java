package com.ulas.gplacesproject.model.request;

import com.ulas.gplacesproject.validator.CustomConstraint;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetPlacesRequest {
    @CustomConstraint(constraintErrorCode = "0005", regexErrorCode = "0003", nullMessage = "0004", min = -90, max = 90)
    @ApiParam(required = true)
    private double latitude;

    @CustomConstraint(constraintErrorCode = "0008", regexErrorCode = "0007", nullMessage = "0006", min = -180, max = 180)
    @ApiParam(required = true)
    private double longitude;

    @CustomConstraint(constraintErrorCode = "0011", regexErrorCode = "0010", nullMessage = "0009")
    @ApiParam(required = true)
    private double radius;
}
