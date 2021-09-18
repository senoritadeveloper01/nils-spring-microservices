package com.nils.microservices.cityscore.rest;

import com.nils.microservices.cityscore.config.CityScoreConfiguration;
import com.nils.microservices.cityscore.model.CityScoreResponse;
import com.nils.microservices.cityscore.model.annotation.ValidCityCode;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Validated
public class CityScoreRestController {

    private final Environment environment;

    private final CityScoreConfiguration cityScoreConfiguration;

    @GetMapping("/city-score/{cityCode}")
    public CityScoreResponse calculateCityScore(@PathVariable @ValidCityCode Integer cityCode) {

        String port = environment.getProperty("local.server.port");

        // throw new RuntimeException("nilsExceptionForCircuitBreakerTest");
        Integer cityScore = cityCode * cityScoreConfiguration.getMultiplierValue();


        return new CityScoreResponse(cityScore, port);
    }
}
