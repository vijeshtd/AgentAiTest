package com.agenticai.test;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.agentic.test.rag.DocumentIngestionService;
import com.agentic.test.rag.DocxReader;
import com.agentic.test.rag.EmbeddingConfig;
import com.agentic.test.rag.EmbeddingStorageService;
import com.agentic.test.rag.RagService;
import com.agentic.test.rag.RetrievalService;
import com.agentic.test.rag.VectorStoreConfig;
import com.agentic.test.services.SalaryAssistant;
import com.agentic.test.tools.SalaryTools;
import com.agenticai.test.config.OpenAIConfig;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.embedding.EmbeddingStore;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Bean
	public CommandLineRunner testChat(ChatLanguageModel chatModel, OpenAIConfig config) {
		return args -> {
			SalaryAssistant assistant = AiServices.builder(SalaryAssistant.class)
			        .chatLanguageModel(chatModel)
			        .tools(new SalaryTools())
			        .build();
//			System.out.println(
//			assistant.process("Salary of Veena is 5000 and Vishnu is 6000 , Vijesh earns 10000"));
			
			// Step 1: Init
			
	        EmbeddingStore<TextSegment> store = VectorStoreConfig.embeddingStore();
	        EmbeddingModel embeddingModel = EmbeddingConfig.embeddingModel(config);

	        // Step 2: Load Document
	        String docText = DocxReader.readDocx("employee.docx");

	        // Step 3: Split + Store
	        List<TextSegment> segments = DocumentIngestionService.splitDocument(docText);
	        EmbeddingStorageService.store(segments, embeddingModel, store);

	        // Step 4: User Query
	        String query = "Total salary of Rahul and Meera";

	        // Step 5: Retrieve Context
	        List<TextSegment> context = RetrievalService.retrieve(query, embeddingModel, store);

	        RagService ragService = new RagService(assistant);
	        String result = ragService.process(query, context);

	        System.out.println(result);
		};
	}
}
