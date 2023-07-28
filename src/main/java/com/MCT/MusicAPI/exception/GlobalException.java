package com.MCT.MusicAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleValidationException(MethodArgumentNotValidException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setResponseStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setResponseMessage("Validation Error");
        // Get all field-level validation errors from the MethodArgumentNotValidException
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        // Create a map to store field-specific error messages
        Map<String, String> fieldErrorMap = new HashMap<>();
        // Iterate through field errors and add them to the map
        for (FieldError fieldError : fieldErrors) {
            fieldErrorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        // Set the field error map in the error handling response
        errorResponse.setFieldErrorMap(fieldErrorMap);
        return errorResponse;
    }
}
