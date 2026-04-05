package com.agenticai.test.model;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.agenticai.test.config.OpenAIConfig;

@Configuration
public class LangChainConfig {

	private final OpenAIConfig openAIConfig;

	public LangChainConfig(OpenAIConfig openAIConfig) {
		this.openAIConfig = openAIConfig;
	}

	@Bean
	public ChatLanguageModel chatLanguageModel() {
		return OpenAiChatModel.builder()
			    .apiKey(openAIConfig.getApiKey())
			    .baseUrl(openAIConfig.getBaseUrl())
			    .modelName(openAIConfig.getModelName())
			    .temperature(openAIConfig.getTemperature())
			    .build();
	}
}