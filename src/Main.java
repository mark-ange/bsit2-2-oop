public class Main {
    public static void main(String[] args) {
        // Create book objects
        Book book1 = new Book("math","james",208);
        Book book2 = new Book("P.E","jay", 320);
        Book book3 = new Book("filipino", "maki", 328);

        book1.displayInfo();
        book2.displayInfo();
        book3.displayInfo();

        book1.borrowBook();
        book1.displayInfo();

        book1.returnBook();
        book1.displayInfo();
    }
}

class Book {
    private String title;
    private String author;
    private int pages;
    private boolean isAvailable;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isAvailable = true;
        System.out.println("A new book '" + title + "' by " + author + " has been added to the library!");
    }


    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
        System.out.println("------------------------------------");
    }


    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have borrowed '" + title + "'.");
        } else {
            System.out.println("Sorry, '" + title + "' is currently not available.");
        }
    }


    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("You have returned '" + title + "'. Thank you!");
        } else {
            System.out.println("'" + title + "' is already in the library.");
        }
    }
}