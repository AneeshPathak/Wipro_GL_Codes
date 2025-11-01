/* Question 3 - Reverse each word in a string
Write a function to reverse each word in a string.

Description :- A method has to be created that takes a string as input and extracts each word from that 
string and then reverse each word individually and gives the output as a reversed string. 

     ****FILE NAME IS GIVEN DIFFERENTLY FOR SORTING OF FILES DAY WISE.***** */

// Answer 

public class Main {

    public static void main(String[] args) {

        String input = "Great Learning";
        System.out.println(reverseEachWord(input));
    }

    static String reverseEachWord(String str) {
        String[] words = str.split(" ");
        String result = "";

        for (String word : words) {
            result += new StringBuilder(word).reverse().toString() + " ";
        }

        return result.trim(); 
    }
}