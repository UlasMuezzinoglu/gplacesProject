package com.ulas.gplacesproject.service.other;

import com.ulas.gplacesproject.interfaces.repository.other.PerformanceNotifyService;
import com.ulas.gplacesproject.model.entity.PerformanceNotifyEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import static com.ulas.gplacesproject.constant.CollectionConstants.PERFORMANCE_NOTIFY;

@Service
@RequiredArgsConstructor
@Primary
public class DatabaseNotifyServiceImpl implements PerformanceNotifyService {

    private final MongoTemplate mongoTemplate;

    @Override
    public void notifyLatedMethod(PerformanceNotifyEntity performanceNotifyEntity) {
        mongoTemplate.save(performanceNotifyEntity, PERFORMANCE_NOTIFY);
    }
}
