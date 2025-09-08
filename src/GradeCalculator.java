import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManager {
    private ArrayList<String> books;
    private Scanner scanner;

    public LibraryManager() {
        books = new ArrayList<>();
        books.add("Java Programming");
        books.add("Web Development");
        books.add("Database Design");
        scanner = new Scanner(System.in);
    }

    public void showBooks() {
        try {
            if (books == null) {
                throw new IllegalStateException("Book list is not initialized.");
            }

            if (books.isEmpty()) {
                System.out.println("The library has no books.");
            } else {
                System.out.println("Books in the library:");
                for (int i = 0; i < books.size(); i++) {
                    System.out.println((i + 1) + ". " + books.get(i));
                }
            }
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Completed displaying books.\n");
        }
    }

    public void addBook() {
        try {
            System.out.print("Enter the book title to add: ");
            String title = scanner.nextLine();

            if (title == null || title.trim().isEmpty()) {
                throw new IllegalArgumentException("Book title cannot be null or empty.");
            }

            if (title.trim().length() < 3) {
                throw new IllegalArgumentException("Book title must be at least 3 characters long.");
            }

            books.add(title.trim());
            System.out.println("Book added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding book: " + e.getMessage());
        } finally {
            System.out.println("Add operation completed.");
            showBooks();
        }
    }

    public void removeBook() {
        try {
            if (books.isEmpty()) {
                System.out.println("Cannot remove book: The library is empty.");
                return;
            }

            System.out.print("Enter the index of the book to remove (1 to " + books.size() + "): ");
            String input = scanner.nextLine();

            int index = Integer.parseInt(input) - 1;

            if (index < 0) {
                throw new IllegalArgumentException("Index cannot be negative.");
            }

            String removedBook = books.remove(index);
            System.out.println("Removed book: " + removedBook);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: Please enter a valid number.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index: Please enter a number within the valid range.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Remove operation completed.");
            showBooks();
        }
    }

    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        manager.showBooks();
        manager.addBook();
        manager.removeBook();
    }
}
