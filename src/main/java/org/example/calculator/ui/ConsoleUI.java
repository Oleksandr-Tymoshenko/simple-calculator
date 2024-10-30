package org.example.calculator.ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.example.calculator.calculator.Calculator;
import org.example.calculator.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ConsoleUI {
    private final Calculator calculator;

    private static final Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    @Autowired
    public ConsoleUI(Calculator calculator) {
        this.calculator = calculator;
    }

    public void start() {
        while (true) {
            try {
                String operation = selectOperation();
                if (operation == null) continue;
                if ("exit".equals(operation)) break;

                double result = calculator.executeOperation(operation);
                if (!Double.isNaN(result)) {
                    System.out.println("Result: " + result);
                }
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    public double getOperand(int operandNumber) {
        System.out.print("Number " + operandNumber + ": ");
        return scanner.nextDouble();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConsoleUI console = context.getBean(ConsoleUI.class);
        console.start();
    }

    private String selectOperation() {
        System.out.print("Select operation (+,-,*,/,MR,M+,M-,M) (\"exit\" for stop the program): ");
        String operation = scanner.next();

        if (!operation.matches("[+\\-*/]|MR|M\\+|M\\-|M|exit")) {
            System.out.println("Invalid operation. Please select from (+, -, *, /, MR, M+, M-, M).");
            return null;
        }
        return operation;
    }
}
