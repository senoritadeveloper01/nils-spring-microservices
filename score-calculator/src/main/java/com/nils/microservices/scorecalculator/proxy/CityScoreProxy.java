package com.nils.microservices.scorecalculator.proxy;

import com.nils.microservices.scorecalculator.model.proxy.CityScoreResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="city-score", fallback = CityScoreFallback.class)
public interface CityScoreProxy {

    @GetMapping("/city-score/{cityCode}")
    public CityScoreResponse calculateCityScore(@PathVariable Integer cityCode);
}
