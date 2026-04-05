package com.agentic.test.rag;

import dev.langchain4j.store.embedding.EmbeddingMatch;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;

import java.util.List;
import java.util.stream.Collectors;

public class RetrievalService {

	public static List<TextSegment> retrieve(String query, EmbeddingModel embeddingModel,
			EmbeddingStore<TextSegment> store) {
		return store.findRelevant(embeddingModel.embed(query).content(), 3).stream().map(EmbeddingMatch::embedded)
				.collect(Collectors.toList());
	}
}