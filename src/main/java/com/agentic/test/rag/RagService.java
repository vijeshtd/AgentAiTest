package com.agentic.test.rag;

import dev.langchain4j.data.segment.TextSegment;

import java.util.List;

import com.agentic.test.services.SalaryAssistant;

public class RagService {

    private final SalaryAssistant salaryAssistant;

    public RagService(SalaryAssistant salaryAssistant) {
        this.salaryAssistant = salaryAssistant;
    }

    public String process(String userQuery, List<TextSegment> contextSegments) {

        String context = contextSegments.stream()
                .map(TextSegment::text)
                .reduce("", (a, b) -> a + "\n" + b);

        String finalInput = """
                CONTEXT:
                %s

                QUESTION:
                %s
                """.formatted(context, userQuery);

        return salaryAssistant.process(finalInput);
    }
}