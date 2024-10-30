package org.example.calculator.calculator;

public interface Calculator {
    double executeOperation(String operation);

    double getMemory();

    void setMemory(double value);
}
