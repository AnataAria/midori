package dev.anataarisa.common.exception;

import lombok.Getter;
import org.sekailabs.jpaq.models.dto.ResponseObject;

import java.util.List;

@Getter
public class BusinessRuleException extends BaseException{
    public BusinessRuleException(String message) {
        super(message);
    }
    public BusinessRuleException(String message, String code) {
        super(message);
        this.errors = new ResponseObject.Builder<Void>()
                .code(code)
                .success(false)
                .messages(List.of(message))
                .build();
    }
}
