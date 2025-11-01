/* uestion 4 - Check Number Parity
            Write a program in java to check whether the given number is an even number or not using if else statement.
    ****FILE NAME IS GIVEN DIFFERENTLY FOR SORTING OF FILES DAY WISE.***** */

// ANSWER: 

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int a = scanner.nextInt();
         if(a%2==0){
             System.out.println("No is Even");
         }
         else{
             System.out.println("No is odd");
         }
        //write your answer here
    }
}