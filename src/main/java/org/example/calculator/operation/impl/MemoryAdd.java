package org.example.calculator.operation.impl;

import org.example.calculator.calculator.Calculator;
import org.example.calculator.operation.Operation;
import org.example.calculator.ui.ConsoleUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemoryAdd implements Operation {
    private final ConsoleUI consoleUI;

    @Autowired
    public MemoryAdd(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public double execute(Calculator calculator) {
        double operand1 = consoleUI.getOperand(1);
        double currentMemory = calculator.getMemory();
        calculator.setMemory(currentMemory + operand1);
        System.out.println("Memory: " + calculator.getMemory());
        return Double.NaN;
    }

    @Override
    public String getName() {
        return "M+";
    }
}
