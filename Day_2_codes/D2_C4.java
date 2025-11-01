/* Question 4 - Equal character in string
            You are given a string s. In one move you can change any character to another character.
            You have to make a string which consists of the same character. Find the minimum move to do this task.

    ****FILE NAME IS GIVEN DIFFERENTLY FOR SORTING OF FILES DAY WISE.***** */

// Answer 

public class Main {

    public static void main(String[] args) {
        String s = "aabbbcccc";
       
        int[] freq = new int[26]; 
        int maxFreq = 0;

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
            if (freq[c - 'a'] > maxFreq)
                maxFreq = freq[c - 'a'];
        }

        System.out.println(s.length() - maxFreq); 
    }

}