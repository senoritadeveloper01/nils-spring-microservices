package com.nils.microservices.scorecalculator.service;

import com.nils.microservices.scorecalculator.domain.IncomeBracketMultiplierInfo;
import com.nils.microservices.scorecalculator.exception.ScoreCalculatorException;
import com.nils.microservices.scorecalculator.model.ScoreCalculatorErrorCode;
import com.nils.microservices.scorecalculator.model.ScoreCalculatorRequest;
import com.nils.microservices.scorecalculator.model.proxy.CityScoreResponse;
import com.nils.microservices.scorecalculator.model.proxy.ScoreSegmentResponse;
import com.nils.microservices.scorecalculator.proxy.CityScoreProxy;
import com.nils.microservices.scorecalculator.proxy.ScoreSegmentProxy;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ScoreCalculatorService {

    private final IncomeBracketMultiplierInfoService incomeBracketMultiplierInfoService;

    private final ScoreSegmentProxy scoreSegmentProxy;

    private final CityScoreProxy cityScoreProxy;

    public BigInteger calculateScore(ScoreCalculatorRequest scoreCalculatorRequest) {
        IncomeBracketMultiplierInfo selectedIncomeBracketMultiplerInfo = getIncomeBracketMultiplerInfo(scoreCalculatorRequest.getIncomeBracketMultiplierId());
        BigInteger scoreSegment = getScoreSegment(scoreCalculatorRequest.getIdNumber());
        Integer cityScore = getCityScore(scoreCalculatorRequest.getCityCode());
        BigInteger score = BigInteger.valueOf(selectedIncomeBracketMultiplerInfo.getMultiplier().intValue())
                                    .multiply(scoreSegment)
                                    .add(BigInteger.valueOf(cityScore.intValue()));

        return score;
    }

    private IncomeBracketMultiplierInfo getIncomeBracketMultiplerInfo(Long incomeBracketMultiplerInfoId) {
        Optional<IncomeBracketMultiplierInfo> multiplierInfo = incomeBracketMultiplierInfoService.findById(incomeBracketMultiplerInfoId);
        if (!multiplierInfo.isPresent()) {
            throw new ScoreCalculatorException(ScoreCalculatorErrorCode.INVALID_INCOME_BRACKET_MULTIPLIER_ID, incomeBracketMultiplerInfoId);
        }
        return multiplierInfo.get();
    }

    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedScoreSegmentResponse")
    // @Retry(name = "score-calculator", fallbackMethod = "hardcodedScoreSegmentResponse")
    private BigInteger getScoreSegment(BigInteger idNumber) {
        ScoreSegmentResponse scoreSegmentResponse = scoreSegmentProxy.retrieveExchangeValue(idNumber);
        return scoreSegmentResponse.getScoreSegment();
    }

    private BigInteger hardcodedScoreSegmentResponse(BigInteger idNumber) {
        return BigInteger.ONE;
    }

    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedCityScoreResponse")
    // @Retry(name = "city-score", fallbackMethod = "hardcodedCityScoreResponse")
    private Integer getCityScore(Integer cityCode) {
        CityScoreResponse cityScoreResponse = cityScoreProxy.calculateCityScore(cityCode);
        return cityScoreResponse.getCityScore();
    }

    private Integer hardcodedCityScoreResponse(Integer cityCode) {
        return 10000;
    }
}
