package com.agentic.test.rag;
import com.agenticai.test.config.OpenAIConfig;

import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.openai.OpenAiEmbeddingModel;

public class EmbeddingConfig {

    public static EmbeddingModel embeddingModel(OpenAIConfig config) {
        return OpenAiEmbeddingModel.builder()
                .apiKey(config.getApiKey())
                .baseUrl(config.getBaseUrl())
                .modelName("text-embedding-3-small")
                .build();
    }
}