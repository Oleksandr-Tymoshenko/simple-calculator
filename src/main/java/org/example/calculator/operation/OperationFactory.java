package org.example.calculator.operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationFactory {
    private static final Map<String, Operation> operations = new HashMap<>();

    @Autowired
    private OperationFactory(List<Operation> operationsList) {
        operationsList.forEach(op -> operations.put(op.getName(), op));
    }

    public static Operation getOperation(String operation) {
        return operations.get(operation);
    }
}
