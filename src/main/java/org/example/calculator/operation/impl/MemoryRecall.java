package org.example.calculator.operation.impl;

import org.example.calculator.calculator.Calculator;
import org.example.calculator.operation.Operation;
import org.example.calculator.ui.ConsoleUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemoryRecall implements Operation {
    @Override
    public double execute(Calculator calculator) {
        System.out.println("Memory: " + calculator.getMemory());
        return Double.NaN;
    }

    @Override
    public String getName() {
        return "MR";
    }
}
