package com.agentic.test.rag;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;

import java.util.List;

public class EmbeddingStorageService {

    public static void store(
            List<TextSegment> segments,
            EmbeddingModel embeddingModel,
            EmbeddingStore<TextSegment> store
    ) {
        segments.forEach(segment -> {
            store.add(
                embeddingModel.embed(segment).content(),
                segment
            );
        });
    }
}