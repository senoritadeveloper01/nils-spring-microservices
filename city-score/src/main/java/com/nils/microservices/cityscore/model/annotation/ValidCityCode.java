package com.nils.microservices.cityscore.model.annotation;

import com.nils.microservices.cityscore.model.CityScoreErrorCodeConstants;
import com.nils.microservices.cityscore.model.validator.CityCodeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CityCodeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCityCode {
    String message() default CityScoreErrorCodeConstants.INVALID_CITY_CODE_VALUE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}