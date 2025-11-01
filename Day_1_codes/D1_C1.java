/*Question 1 - Write a program that takes two numbers as input from the user and performs arithmetic operations on them using 
            the arithmetic operators (sum, difference, product, quotient, remainder) in Java.

    ****FILE NAME IS GIVEN DIFFERENTLY FOR SORTING OF FILES DAY WISE.***** */

// ANSWER:

import java.util.Scanner;

public class ArithmeticOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //System.out.println("Enter the first number:-"); 
        int a = scanner.nextInt(); 
        //System.out.println("Enter the second number:-"); 
        int b = scanner.nextInt(); 
        
        int sum = a+b; 
        int diff = a-b; 
        int prod = a*b; 
        int quo = a/b; 
        int rem = a%b; 
        System.out.println("Sum: " + sum); 
        System.out.println("Difference: " + diff); 
        System.out.println("Product: " + prod); 
        System.out.println("Quotient: " + quo); 
        System.out.println("Remainder: " + rem);
        scanner.close();
    }
}