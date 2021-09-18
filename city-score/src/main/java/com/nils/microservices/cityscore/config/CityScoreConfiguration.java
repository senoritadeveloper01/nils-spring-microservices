package com.nils.microservices.cityscore.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
@RefreshScope
@ConfigurationProperties(prefix = "city-score")
public class CityScoreConfiguration {

    private Integer multiplierValue;
}