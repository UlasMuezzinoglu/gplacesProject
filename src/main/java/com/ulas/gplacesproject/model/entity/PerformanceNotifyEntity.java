package com.ulas.gplacesproject.model.entity;

import com.ulas.gplacesproject.model.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.ulas.gplacesproject.constant.CollectionConstants.PERFORMANCE_NOTIFY;

@Getter
@Setter
@Document(collection = PERFORMANCE_NOTIFY)
public class PerformanceNotifyEntity extends BaseEntity {

    private String methodName;

    private long executedTime;

    private int definedExecutedTime;


}
