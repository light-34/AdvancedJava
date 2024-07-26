package org.adv.bufferedreader;

import java.io.*;

public class BufferedReaderDemo {
    public static String readFileContentV1(File file) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){

            reader.lines().forEach(line -> sb.append(line).append(" - "));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return sb.toString();
    }

    public static String readInput() {
        String result = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Please enter a number: ");
            int fNum = Integer.parseInt(reader.readLine().trim());
            System.out.println("Please enter another number: ");
            int sNum = Integer.parseInt(reader.readLine().trim());
            System.out.println("Please enter an operator such as (+, -, *, /, %, ^)");
            String operator = reader.readLine().trim();

            result = "Result is : " + calculate(fNum, sNum, operator);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public static double calculate(Integer fNum, Integer sNum, String operator) {
        if (fNum != null && sNum != null && operator != null) {
            switch (operator) {
                case "+" -> {
                    return (double) fNum + sNum;
                }
                case "-" -> {
                    return (double) fNum - sNum;
                }
                case "*" -> {
                    return (double) fNum * sNum;
                }
                case "/" -> {
                    if (sNum == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    return (double) fNum / sNum;
                }
                case "%" -> {
                    return (double) fNum % sNum;
                }
                case "^" -> {
                    return Math.pow(fNum, sNum);
                }
                default -> throw new ArithmeticException("Invalid operator: " + operator);
            }
        }
        return 0;
    }
}
