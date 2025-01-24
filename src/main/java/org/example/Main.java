package org.example;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("First Number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Give the Operator (+, -, *, /, √): "); // √ is the square root symbol
            char operator = scanner.next().charAt(0);

            double num2 = 0; // Initialize num2 for operators that don't use it
            if (operator != '√') {
                System.out.print("Second Number: ");
                num2 = scanner.nextDouble();
            }

            try {
                double result = calculate(num1, num2, operator);
                System.out.println("Result: " + result);
                saveResultToFile(result);
            } catch (ArithmeticException e) {
                System.out.println("Arithmetic Error: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
            case '√': // Square root operator- Fatjona
                if (num1 >= 0) {
                    return Math.sqrt(num1);
                } else {
                    throw new ArithmeticException("Cannot calculate the square root of a negative number.");
                }
            default:
                throw new IllegalArgumentException("Incorrect operator!");
        }
    }

    public static void saveResultToFile(double result) {
        String resultString = "The Result is: " + result;
        Path filePath = Path.of("result.txt");
        if (result > 100) {
            System.out.println("Wow! That's a big result.");
        }

        try {
            Files.writeString(filePath, resultString, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("The Result is Successfully saved in result.txt.");
        } catch (Exception e) {
            System.out.println("Failed to save the result to the file: " + e.getMessage());
        }
    }
}
