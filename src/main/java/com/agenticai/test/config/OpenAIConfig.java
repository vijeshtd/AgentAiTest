package com.agenticai.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAIConfig {

    @Value("${openai.api-key}")
    private String apiKey;
    
    @Value("${openai.base-url}")
    private String baseUrl;

    @Value("${openai.model-name}")
    private String modelName;

    @Value("${openai.temperature}")
    private double temperature;

    public String getApiKey() {
        return apiKey;
    }

    public String getModelName() {
        return modelName;
    }
    
    public String getBaseUrl() {
        return baseUrl;
    }

    public double getTemperature() {
        return temperature;
    }
}