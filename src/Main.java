public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();

        Student studentJohn = new Student("S101", "U1", "John Smith", "john@mail.com", "Computer Science");
        Faculty facultySmith = new Faculty("U2", "Dr. Smith", "smith@mail.com", "Engineering", "Professor");

        Book book = new Book("978-123", "B001", "Java Programming", "James Gosling", 300, "Programming");
        Magazine mag = new Magazine("M001", "Tech Today", "Editor Smith", 42, "Nov", true);
        DVD dvd = new DVD("D001", "The Matrix", "Wachowski Sisters", 136, "R", "Sci-Fi");

        System.out.println("== LIBRARY MANAGEMENT SYSTEM TEST ==");

        System.out.println("\n== Adding Items to Library ==");
        manager.addItem(book);
        manager.addItem(mag);
        manager.addItem(dvd);

        System.out.println("\n== Displaying All Items ==");
        System.out.println(book.getItemType() + ": " + book.getTitle() + " (Available for borrowing)");
        System.out.println(mag.getItemType() + ": " + mag.getTitle() + " (Available for borrowing)");
        System.out.println(dvd.getItemType() + ": " + dvd.getTitle() + " (DVD: Available for borrowing)");


        System.out.println("\n== Testing Borrowing ==");
        manager.borrowItem(book.getItemId(), studentJohn);
        System.out.println("Student John borrowed: " + book.getTitle());

        manager.borrowItem(dvd.getItemId(), facultySmith);
        System.out.println("Faculty Dr. Smith borrowed: " + dvd.getTitle());


        System.out.println("\n== Displaying Available Items ==");
        if (mag.isAvailable()) {
            System.out.println("Magazine: " + mag.getTitle() + " (Available for borrowing)");
        }


        System.out.println("\n== Testing Late Fees ==");
        int daysLateBook = 5;
        int daysLateDVD = 3;

        double feeBook = book.calculateLateFee(daysLateBook);
        System.out.printf(book.getTitle() + " - %d days late: $%.2f%n", daysLateBook, feeBook);

        double feeDVD = dvd.calculateLateFee(daysLateDVD);
        System.out.printf(dvd.getTitle() + " - %d days late: $%.2f%n", daysLateDVD, feeDVD);

        System.out.println("\n== Testing User Information ==");
        System.out.printf("Student: %s (%s) - %d items borrowed%n",
                studentJohn.getName(), studentJohn.getMajor(), studentJohn.getBorrowedItemsCount());

        System.out.printf("Faculty: %s (%s) - %d items borrowed%n",
                facultySmith.getName(), facultySmith.getDepartment(), facultySmith.getBorrowedItemsCount());
    }
}
