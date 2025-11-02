/* Question 2 - Sum of All Numbers
                Find the sum of the digits using recursion

    ****FILE NAME IS GIVEN DIFFERENTLY FOR SORTING OF FILES DAY WISE.***** */

// Answer 

import java.util.Scanner;

public class SumOfDigits {
    // Recursive function to find sum of digits
    public static int sumOfDigits(int n) {
        if (n == 0)
            return 0;
        return (n % 10) + sumOfDigits(n / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = sumOfDigits(num);
        System.out.println(sum);
        sc.close();
    }
}