package com.roman;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter roman numerals to convert: ");
            String input;
            while ((input = scanner.next()) != null) {
                try{
                    int convertedValue = RomanToIntConverter.convert(input);
                    System.out.println("converted value: " + convertedValue);
                } catch (IllegalArgumentException exception) {
                    System.out.println(exception.getMessage());
                }
                System.out.println("Please enter roman numerals to convert: ");
            }
    }
}
