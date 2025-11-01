/* Question 3 - Write a program that takes two integers as input and compares them using relational operators. 
            Print 'true' if the first integer is greater than the second integer, and 'false' otherwise.

    ****FILE NAME IS GIVEN DIFFERENTLY FOR SORTING OF FILES DAY WISE.***** */

// ANSWER: 

import java.util.Scanner;

public class RelationalOperatorExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        
        if(num1>num2){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
        scanner.close();
    }
}