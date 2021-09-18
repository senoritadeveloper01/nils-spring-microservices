package com.nils.microservices.scoresegment.rest;

import com.nils.microservices.scoresegment.model.ScoreSegmentResponse;
import com.nils.microservices.scoresegment.model.validator.ValidIdNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RequiredArgsConstructor
@RestController
@Validated
public class ScoreSegmentRestController {

    private final Environment environment;

    @GetMapping("/score-segment/{idNumber}")
    public ScoreSegmentResponse calculateScoreSegment(@PathVariable @ValidIdNumber BigInteger idNumber) {

        String port = environment.getProperty("local.server.port");

        BigInteger scoreSegment = idNumber.mod(new BigInteger("9"));
        scoreSegment = scoreSegment.compareTo(BigInteger.ZERO)  == 0 ? BigInteger.ONE : scoreSegment;

        // throw new RuntimeException("nilsExceptionForCircuitBreakerTest");

        return new ScoreSegmentResponse(scoreSegment, port);
    }
}
