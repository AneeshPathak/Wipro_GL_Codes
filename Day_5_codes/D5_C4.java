/* Question 4 - Generic Data Analysis using JAVA

    ****FILE NAME IS GIVEN DIFFERENTLY FOR SORTING OF FILES DAY WISE.***** */

// Answer 
import java.util.*;

class DataAnalyzer<T extends Comparable<T>> {
    private T[] data;

    // Constructor
    public DataAnalyzer(T[] data) {
        this.data = data;
    }

    // Method to calculate average for numeric data
    public double calculateAverage() {
        double sum = 0.0;
        int count = 0;
        for (T value : data) {
            if (value instanceof Number) {
                sum += ((Number) value).doubleValue();
                count++;
            }
        }
        return count > 0 ? sum / count : 0.0;
    }

    // Method to find maximum for comparable data
    public T findMaximum() {
        if (data == null || data.length == 0)
            return null;
        T max = data[0];
        for (T value : data) {
            if (value.compareTo(max) > 0)
                max = value;
        }
        return max;
    }

    // Method to print summary
    public void dataSummary() {
        System.out.println("Data Summary:");
        System.out.println("Average: " + calculateAverage());
        System.out.println("Maximum: " + findMaximum());
    }
}

// Driver Code
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Double[] arr = new Double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }

        DataAnalyzer<Double> analyzer = new DataAnalyzer<>(arr);
        analyzer.dataSummary();
    }
}
