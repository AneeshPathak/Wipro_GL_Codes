/* Question 3 - Create a Java class named Book to represent a book

    ****FILE NAME IS GIVEN DIFFERENTLY FOR SORTING OF FILES DAY WISE.***** */

// Answer 

public class Book {
    String title;
    String author;
    int year;

    public static void main(String[] args) {
        Book myBook = new Book();
        myBook.title = "The Alchemist";
        myBook.author = "Paulo Coelho";
        myBook.year = 1988;

        System.out.println("Book Title: " + myBook.title);
        System.out.println("Author: " + myBook.author);
        System.out.println("Publication Year: " + myBook.year);
    }
}
