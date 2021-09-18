package com.nils.microservices.scoresegment.model.annotation;

import com.nils.microservices.scoresegment.model.validator.ValidIdNumber;
import com.nils.microservices.scoresegment.utils.IdNumberUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigInteger;

public class IdNumberValidator implements ConstraintValidator<ValidIdNumber, BigInteger> {

    @Override
    public boolean isValid(BigInteger value, ConstraintValidatorContext context) {
        if (value == null && !IdNumberUtils.isValid(value.toString())) {
            return false;
        }
        return true;
    }
}
