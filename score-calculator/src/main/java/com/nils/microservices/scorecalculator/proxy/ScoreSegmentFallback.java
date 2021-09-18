package com.nils.microservices.scorecalculator.proxy;

import com.nils.microservices.scorecalculator.model.proxy.ScoreSegmentResponse;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class ScoreSegmentFallback implements ScoreSegmentProxy {

    @Override
    public ScoreSegmentResponse retrieveExchangeValue(BigInteger idNumber) {
        return new ScoreSegmentResponse(BigInteger.ONE);
    }
}
