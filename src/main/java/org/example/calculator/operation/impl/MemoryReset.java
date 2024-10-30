package org.example.calculator.operation.impl;

import org.example.calculator.calculator.Calculator;
import org.example.calculator.operation.Operation;
import org.springframework.stereotype.Component;

@Component
public class MemoryReset implements Operation {
    @Override
    public double execute(Calculator calculator) {
        calculator.setMemory(0);
        System.out.println("Memory: " + calculator.getMemory());
        return Double.NaN;
    }

    @Override
    public String getName() {
        return "M";
    }
}
