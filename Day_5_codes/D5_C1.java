/* Question 1 - Write a Java program that takes two integers as input and performs division. The program should handle exceptions for 
                invalid input (non-integer input) and division by zero. The program should continue to prompt the user for valid input until 
                successful division is performed.

    ****FILE NAME IS GIVEN DIFFERENTLY FOR SORTING OF FILES DAY WISE.***** */

// Answer 

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        try {
            int n = scn.nextInt();
            
            try {
                if (99 % n == 0) {
                    System.out.println(n + " is a factor of 99");
                } else {
                    System.out.println(n + " is a not a factor of 99");
                }
            } catch (ArithmeticException e) {
                System.out.println("Arithmetic Exception java.lang.ArithmeticException: / by zero");
            }
            
        } catch (Exception e) {
            System.out.println("Number Format Exception java.lang.NumberFormatException: For input string: \"" + scn.next() + "\"");
        }
        
        scn.close();
    }
}