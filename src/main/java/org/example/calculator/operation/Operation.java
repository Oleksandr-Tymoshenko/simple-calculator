package org.example.calculator.operation;

import org.example.calculator.calculator.Calculator;

public interface Operation {
    double execute(Calculator calculator);

    String getName();
}
