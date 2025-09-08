package dev.anataarisa.common.model;

import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
public abstract class BaseResponse {
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
