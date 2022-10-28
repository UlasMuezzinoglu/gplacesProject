package com.ulas.gplacesproject.model.entity;

import com.ulas.gplacesproject.model.common.BaseEntity;
import com.ulas.gplacesproject.model.enums.PlacesSearchStatusEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

import static com.ulas.gplacesproject.constant.CollectionConstants.PLACES;

@Getter
@Setter
@Document(collection = PLACES)
@CompoundIndex(def = "{'latitude':1, 'longitude':1, 'radius':1}", name = "latitude_longitude,radius")
public class PlaceEntity extends BaseEntity {
    private List<ResultModel> results;
    private PlacesSearchStatusEnum status;
    private double latitude;
    private double longitude;
    private double radius;
}
