package com.nils.microservices.scoresegment.model.validator;

import com.nils.microservices.scoresegment.model.ScoreSegmentErrorCodeConstants;
import com.nils.microservices.scoresegment.model.annotation.IdNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IdNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidIdNumber {

    String message() default ScoreSegmentErrorCodeConstants.INVALID_ID_NUMBER_VALUE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
