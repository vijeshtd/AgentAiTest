package com.agentic.test.tools;
import java.util.List;

import dev.langchain4j.agent.tool.Tool;

public class SalaryTools {

    @Tool("Calculate total salary from list of numbers")
    public double sumSalaries(List<Double> salaries) {
    	System.out.println("Calculating salary");
        return salaries.stream().mapToDouble(Double::doubleValue).sum();
    }
}

