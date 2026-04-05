package com.agentic.test.services;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface SalaryAssistant {

//    @SystemMessage("""
//        You are an assistant.
//        Extract all salary values from the input.
//        Return the total salary.
//        I want to have the final output as a json (sample below):
//        {"salary":2000}
//    """)
    @SystemMessage("""
            You are an assistant.

            You will be given CONTEXT containing employee salary details.

            Instructions:
            1. Extract salary values ONLY for the employees mentioned in the question
            2. Convert them into numbers
            3. MUST call the tool 'sumSalaries'
            4. Return the final total
        """)
    String process(@UserMessage String document);
}