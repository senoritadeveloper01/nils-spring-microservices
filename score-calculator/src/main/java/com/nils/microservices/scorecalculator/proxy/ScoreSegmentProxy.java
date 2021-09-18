package com.nils.microservices.scorecalculator.proxy;

import com.nils.microservices.scorecalculator.model.proxy.ScoreSegmentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigInteger;

@FeignClient(name="score-segment", fallback = ScoreSegmentFallback.class)
public interface ScoreSegmentProxy {

    @GetMapping("/score-segment/{idNumber}")
    public ScoreSegmentResponse retrieveExchangeValue(@PathVariable BigInteger idNumber);
}
