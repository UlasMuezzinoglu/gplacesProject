package com.ulas.gplacesproject.interfaces.mapper;

import com.ulas.gplacesproject.interfaces.mapper.common.BaseMapper;
import com.ulas.gplacesproject.model.entity.PlaceEntity;
import com.ulas.gplacesproject.model.request.GetPlacesRequest;
import com.ulas.gplacesproject.model.response.PlaceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlaceMapper extends BaseMapper<GetPlacesRequest, PlaceEntity , PlaceResponse> {

}
