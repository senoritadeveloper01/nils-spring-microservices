package com.nils.microservices.cityscore.exception;

import com.nils.microservices.cityscore.model.CityScoreErrorCodeConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.Date;

@ControllerAdvice
@RestController // because it is providing a response back
public class CityScoreResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleValidationExceptions(Exception ex, WebRequest request) {
        CityScoreExceptionResponse exceptionResponse =
                new CityScoreExceptionResponse(new Date(), CityScoreErrorCodeConstants.INVALID_CITY_CODE_VALUE,
                        ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public final ResponseEntity<Object> handleMethodArgumentTypeMismatchExceptions(Exception ex, WebRequest request) {
        CityScoreExceptionResponse exceptionResponse =
                new CityScoreExceptionResponse(new Date(), CityScoreErrorCodeConstants.INVALID_PARAMETER_TYPE,
                        ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
