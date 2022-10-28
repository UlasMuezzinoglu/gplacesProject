package com.ulas.gplacesproject.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Photo {
    private int height;
    private ArrayList<String> html_attributions;
    private String photo_reference;
    private int width;
}
