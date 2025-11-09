/* Question 4 - Write a java program to remove an element from the Map, you can use the remove() method. This method takes the key value and 
                removes the mapping for a key from this map if it is present in the map.


    ****FILE NAME IS GIVEN DIFFERENTLY FOR SORTING OF FILES DAY WISE.***** */

// Answer 

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> map = new HashMap<>();

        for (int i = 1; i <= 4; i++) {
            map.put(i, sc.next());
        }

        int keyToRemove = sc.nextInt();

        System.out.println("Mappings of HashMap are : " + map);

        map.remove(keyToRemove);

        System.out.println("Mappings after removal are : " + map);
    }
}
