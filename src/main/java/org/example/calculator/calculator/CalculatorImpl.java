package org.example.calculator.calculator;

import org.example.calculator.operation.Operation;
import org.example.calculator.operation.OperationFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CalculatorImpl implements Calculator {
    private double memory = 0;

    @Override
    public double executeOperation(String operation) {
        Operation op = OperationFactory.getOperation(operation);
        return op.execute(this);
    }

    @Override
    public double getMemory() {
        return memory;
    }

    @Override
    public void setMemory(double value) {
        this.memory = value;
    }
}
