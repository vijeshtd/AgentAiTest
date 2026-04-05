package com.agentic.test.rag;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.splitter.DocumentSplitters;
import dev.langchain4j.data.segment.TextSegment;

import java.util.List;

public class DocumentIngestionService {

    public static List<TextSegment> splitDocument(String text) {
        Document document = Document.from(text);

        return DocumentSplitters.recursive(500, 50)
                .split(document);
    }
}