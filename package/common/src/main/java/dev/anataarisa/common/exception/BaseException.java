package dev.anataarisa.common.exception;

import lombok.Getter;
import org.sekailabs.jpaq.models.dto.ResponseObject;

@Getter
public abstract class BaseException extends RuntimeException {
    protected ResponseObject<Void> errors;
    public BaseException(String message) {
        super(message);
    }
    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
