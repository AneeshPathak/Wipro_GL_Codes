/* Question 2 - Design a generic class Test to make the main work for Number classes, do not alter main class

    ****FILE NAME IS GIVEN DIFFERENTLY FOR SORTING OF FILES DAY WISE.***** */

// Answer 

class Test<T extends Number> {
    private T num;

    public Test(T num) {
        this.num = num;
    }

    public void displaySum() {
        System.out.println("the sum is = " + (num.doubleValue() + 49.0));
    }
}

public class Main {
    public static void main(String[] args) {
        Test<Integer> t = new Test<>(1);
        t.displaySum();
    }
}
