package com.ulas.gplacesproject.model.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter
public class ResultModel {
    private Geometry geometry;
    private String icon;
    private String icon_background_color;
    private String icon_mask_base_uri;
    private String name;
    private ArrayList<Photo> photos;
    private String place_id;
    private String reference;
    private String scope;
    private ArrayList<String> types;
    private String vicinity;
}
