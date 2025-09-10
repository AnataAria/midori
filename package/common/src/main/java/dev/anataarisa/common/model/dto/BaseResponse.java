package dev.anataarisa.common.model.dto;

import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
public abstract class BaseResponse {
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
