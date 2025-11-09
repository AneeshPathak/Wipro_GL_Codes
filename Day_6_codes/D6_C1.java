/* Question 1 - Sort the Collection
                students are provided with a challenge to sort the given arraylist in the lesser lines of code. Student with minimum lines will 
                win , try to write a code for it in less lines and win

    ****FILE NAME IS GIVEN DIFFERENTLY FOR SORTING OF FILES DAY WISE.***** */

// Answer 

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }

        System.out.println("List before sort: " + list);
        Collections.sort(list);
        System.out.println("List after sort: " + list);
    }
}