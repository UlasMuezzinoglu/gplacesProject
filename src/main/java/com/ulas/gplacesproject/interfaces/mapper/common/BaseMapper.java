package com.ulas.gplacesproject.interfaces.mapper.common;

import java.util.List;

public interface BaseMapper<Request, Entity, Response>{
    Response toResponse(Entity entity);

    Entity toEntity(Request request);

    Request toRequest(Entity entity);

    List<Response> toResponses(List<Entity> entities);
}
