package com.ulas.gplacesproject.model.response;

import com.ulas.gplacesproject.model.entity.ResultModel;
import com.ulas.gplacesproject.model.enums.PlacesSearchStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlaceResponse {
    private List<ResultModel> results;
    private PlacesSearchStatusEnum status;
    private String next_page_token;
}
