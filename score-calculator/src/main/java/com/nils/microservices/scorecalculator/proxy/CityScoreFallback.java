package com.nils.microservices.scorecalculator.proxy;

import com.nils.microservices.scorecalculator.model.proxy.CityScoreResponse;
import org.springframework.stereotype.Component;

@Component
public class CityScoreFallback implements CityScoreProxy {

    @Override
    public CityScoreResponse calculateCityScore(Integer cityCode) {
        return new CityScoreResponse(1);
    }
}
