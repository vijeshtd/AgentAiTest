package com.agentic.test.rag;
import java.io.InputStream;

import org.apache.tika.Tika;
import org.springframework.core.io.ClassPathResource;

public class DocxReader {

    public static String readDocx(String fileName) {
    	try {
            ClassPathResource resource = new ClassPathResource(fileName);
            InputStream inputStream = resource.getInputStream();

            Tika tika = new Tika();
            return tika.parseToString(inputStream);

        } catch (Exception e) {
            throw new RuntimeException("Failed to read DOCX from resources", e);
        }
    }
}