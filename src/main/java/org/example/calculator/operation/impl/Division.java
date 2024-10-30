package org.example.calculator.operation.impl;

import org.example.calculator.calculator.Calculator;
import org.example.calculator.operation.Operation;
import org.example.calculator.ui.ConsoleUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Division implements Operation {
    private final ConsoleUI consoleUI;

    @Autowired
    public Division(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public double execute(Calculator calculator) {
        double operand1 = consoleUI.getOperand(1);
        double operand2 = consoleUI.getOperand(2);
        if (operand2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return operand1 / operand2;
    }

    @Override
    public String getName() {
        return "/";
    }
}
