package com.ulas.gplacesproject.service.other;

import com.ulas.gplacesproject.core.LoggingBean;
import com.ulas.gplacesproject.interfaces.repository.other.PerformanceNotifyService;
import com.ulas.gplacesproject.model.entity.PerformanceNotifyEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ElasticSearchNotifyServiceImpl implements PerformanceNotifyService {
    private final LoggingBean logger;

    @Override
    public void notifyLatedMethod(PerformanceNotifyEntity performanceNotifyEntity) {
        logger.performance.error(performanceNotifyEntity.getMethodName() + " named method is delayed !"
                + " Expected Maximum MS : " + performanceNotifyEntity.getDefinedExecutedTime() + " Runtime MS : "
                + performanceNotifyEntity.getExecutedTime());
    }
}
