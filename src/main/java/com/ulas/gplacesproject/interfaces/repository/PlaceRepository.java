package com.ulas.gplacesproject.interfaces.repository;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.ulas.gplacesproject.constant.ErrorConstants;
import com.ulas.gplacesproject.exception.CustomException;
import com.ulas.gplacesproject.interfaces.repository.common.BaseRepository;
import com.ulas.gplacesproject.model.entity.PlaceEntity;
import com.ulas.gplacesproject.model.request.GetPlacesRequest;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ulas.gplacesproject.constant.CollectionConstants.PLACES;

@Repository
public interface PlaceRepository extends BaseRepository<PlaceEntity, String> {
    default PlaceEntity findByLatLongRadius(GetPlacesRequest getPlacesRequest, MongoDatabase mongoDatabase) {
        MongoCursor<PlaceEntity> mongoCursor = mongoDatabase.getCollection(PLACES, PlaceEntity.class)
                .aggregate(List.of(
                        new Document("$match", new Document("latitude", getPlacesRequest.getLatitude())
                                .append("longitude",getPlacesRequest.getLongitude())
                                .append("radius",getPlacesRequest.getRadius())),
                        new Document("$addFields",
                                new Document("_id",
                                        new Document("$toString", "$_id")
                                )
                        )
                )).cursor();
        if (!mongoCursor.hasNext()) return null;
        return mongoCursor.next();
    }
}
