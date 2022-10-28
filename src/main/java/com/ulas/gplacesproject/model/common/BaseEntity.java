package com.ulas.gplacesproject.model.common;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field
    @CreatedDate
    private Date createdDate;

    @Field
    @LastModifiedDate
    private Date updatedDate;

    @Field
    @LastModifiedBy
    private String updatedBy;

    @Field
    @CreatedBy
    private String createdBy;
}

