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


            System.out.print("Give the Operator(+, -, *, /): ");
            char operator = scanner.next().charAt(0);


            System.out.print("Second Number: ");
            double num2 = scanner.nextDouble();



            try {
                double result = calculate(num1, num2, operator);
                System.out.println("Result: " + result);
                saveResultToFile(result);
            } catch (ArithmeticException e) {
                System.out.println("Arithmetic Error");
            }



        } catch (Exception e) {


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
                } else if(num2 != 0) {
                    return num1 / num2;
                }else {
                    System.out.println("Devision with Zero!");
                    System.exit(1);
                }
            default:
                System.out.println("Incorrect operator!");
                System.exit(1);
        }
        return 0;
    }


    public static void saveResultToFile(double result) {
        String resultString = "The Result is: " + result;
        Path filePath = Path.of("result.txt");
        if (result > 100) {
            System.out.println("Wow! That's a big result.");
        }

        try {
            Files.writeString(filePath, resultString, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("The Result is Successfully in result.txt saved.");
        } catch (Exception e) {
        }
        }
    }
