
public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    private int yearPublished;

    public Book(String title, String author, String isbn, int yearPublished) {
        setTitle(title);
        setAuthor(author);
        setIsbn(isbn);
        setYearPublished(yearPublished);
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        this.title = title;
    }

    public void setAuthor(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty.");
        }
        this.author = author;
    }

    public void setIsbn(String isbn) {
        if (isbn == null || (isbn.length() != 10 && isbn.length() != 13)) {
            throw new IllegalArgumentException("ISBN must be 10 or 13 characters long.");
        }
        this.isbn = isbn;
    }

    public void setYearPublished(int year) {
        if (year < 1450 || year > 2025) {
            throw new IllegalArgumentException("Year must be between 1450 and 2025.");
        }
        this.yearPublished = year;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public boolean borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    public boolean returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            return true;
        }
        return false;
    }

    public void displayBookInfo() {
        System.out.println("Title: " + title + " | Author: " + author + " | ISBN: " + isbn + " | Year: " + yearPublished + " | Status: " + (isAvailable ? "Available" : "Borrowed"));
    }
}

// Library.java
public class Library {
    private Book[] books;
    private int bookCount;

    public Library() {
        books = new Book[10];
        bookCount = 0;
    }

    public boolean addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount++] = book;
            return true;
        }
        return false;
    }

    public boolean removeBook(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[--bookCount] = null;
                return true;
            }
        }
        return false;
    }

    public Book findBook(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                return books[i];
            }
        }
        return null;
    }

    public boolean borrowBook(String isbn) {
        Book book = findBook(isbn);
        if (book != null) {
            return book.borrowBook();
        }
        return false;
    }

    public boolean returnBook(String isbn) {
        Book book = findBook(isbn);
        if (book != null) {
            return book.returnBook();
        }
        return false;
    }

    public void displayAvailableBooks() {
        System.out.println("Available books:");
        for (int i = 0; i < bookCount; i++) {
            if (books[i].isAvailable()) {
                books[i].displayBookInfo();
            }
        }
    }

    public void displayAllBooks() {
        System.out.println("All books in library:");
        for (int i = 0; i < bookCount; i++) {
            books[i].displayBookInfo();
        }
    }

    public int getBookCount() {
        return bookCount;
    }
}


public class Book {
    public static void main(String[] args) {
        Library library = new Library();

  
        Book book1 = new Book("Java Programming", "John Smith", "1234567890", 2020);
        Book book2 = new Book("Data Structures", "Jane Doe", "9876543210", 2019);
        Book book3 = new Book("Web Development", "Mike Johnson", "5555666677", 2021);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

  
        library.displayAllBooks();

     
        System.out.println("\nBorrowing Java Programming...");
        library.borrowBook("1234567890");

      
        System.out.println("\nTrying to borrow Java Programming again...");
        library.borrowBook("1234567890");

     
        System.out.println("\nReturning Java Programming...");
        library.returnBook("1234567890");

       
        System.out.println("\nDisplaying available books...");
        library.displayAvailableBooks();

        
        System.out.println("\nTesting invalid data...");
        try {
            new Book("Invalid Book", "Invalid Author", "123", 1400);  
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
