/* Question 3 - Library Management System

    ****FILE NAME IS GIVEN DIFFERENTLY FOR SORTING OF FILES DAY WISE.***** */

// Answer 

import java.util.*;

abstract class LibraryItem {
    private int itemId;
    private String title;
    private String creator;
    private boolean checkedOut;

    public LibraryItem(int itemId, String title, String creator) {
        this.itemId = itemId;
        this.title = title;
        this.creator = creator;
        this.checkedOut = false;
    }

    public int getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getCreator() { return creator; }

    public void checkOut() {
        if (checkedOut)
            throw new ItemAlreadyCheckedOutException(itemId);
        checkedOut = true;
    }

    public void returnItem() {
        if (!checkedOut)
            throw new ItemNotCheckedOutException(itemId);
        checkedOut = false;
    }

    @Override
    public String toString() {
        return "ID: " + itemId + ", Title: " + title + ", Creator: " + creator +
               ", Checked Out: " + (checkedOut ? "Yes" : "No");
    }
}

class Book extends LibraryItem {
    private int numPages;
    public Book(int itemId, String title, String author, int numPages) {
        super(itemId, title, author);
        this.numPages = numPages;
    }
    public int getNumPages() { return numPages; }
}

class DVD extends LibraryItem {
    private int duration;
    public DVD(int itemId, String title, String director, int duration) {
        super(itemId, title, director);
        this.duration = duration;
    }
    public int getDuration() { return duration; }
}

class Magazine extends LibraryItem {
    private int issueNumber;
    public Magazine(int itemId, String title, String publisher, int issueNumber) {
        super(itemId, title, publisher);
        this.issueNumber = issueNumber;
    }
    public int getIssueNumber() { return issueNumber; }
}

class Library<T extends LibraryItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) { items.add(item); }

    public void displayItems() {
        for (T item : items)
            System.out.println(item);
    }

    public boolean checkOutItem(int itemId) {
        T item = findItem(itemId);
        if (item != null) {
            try {
                item.checkOut();
                return true;
            } catch (ItemAlreadyCheckedOutException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    public boolean returnItem(int itemId) {
        T item = findItem(itemId);
        if (item != null) {
            try {
                item.returnItem();
                return true;
            } catch (ItemNotCheckedOutException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    private T findItem(int itemId) {
        for (T item : items)
            if (item.getItemId() == itemId)
                return item;
        return null;
    }
}

class ItemAlreadyCheckedOutException extends RuntimeException {
    public ItemAlreadyCheckedOutException(int itemId) {
        super("Item " + itemId + " is already checked out");
    }
}

class ItemNotCheckedOutException extends RuntimeException {
    public ItemNotCheckedOutException(int itemId) {
        super("Item " + itemId + " is not checked out");
    }
}

public class EnhancedLibraryManagementSystem {
    public static void main(String[] args) {
        Library<LibraryItem> lib = new Library<>();
        lib.addItem(new Book(101, "The Alchemist", "Paulo Coelho", 200));
        lib.addItem(new DVD(102, "Inception", "Christopher Nolan", 148));
        lib.addItem(new Magazine(103, "NatGeo", "National Geographic", 78));

        lib.displayItems();
        lib.checkOutItem(101);
        lib.checkOutItem(101);
        lib.returnItem(101);
        lib.returnItem(101);
    }
}
