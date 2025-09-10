package dev.anataarisa.common.exception;

import org.sekailabs.jpaq.models.dto.ResponseObject;

import java.util.List;

public class ActionFailedException extends BaseException{
    public ActionFailedException(String message) {
        super(message);
    }
    public ActionFailedException(String message, Throwable cause) {
        super(message, cause);
        errors = new ResponseObject.Builder<Void>()
                .success(false)
                .messages(List.of(message))
                .code("ACTION_FAILED")
                .build();
    }
}
