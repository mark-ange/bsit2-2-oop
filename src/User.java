import java.util.ArrayList;
import java.util.List;

abstract class User {

    private String userId;
    private String name;
    private String email;
    private List<LibraryItem> borrowedItems;

    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.borrowedItems = new ArrayList<>();
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getBorrowedItemsCount() { return borrowedItems.size(); }
    public List<LibraryItem> getBorrowedItems() { return borrowedItems; }

    public void addBorrowedItem(LibraryItem item) {
        borrowedItems.add(item);
    }

    public void removeBorrowedItem(LibraryItem item) {
        borrowedItems.remove(item);
    }

    public void displayBorrowedItems() {
        System.out.println("\n--- " + name + "'s Borrowed Items (" + getBorrowedItemsCount() + ") ---");
        if (borrowedItems.isEmpty()) {
            System.out.println("No items currently borrowed.");
            return;
        }
        for (LibraryItem item : borrowedItems) {
            System.out.println("  - " + item.getItemInfo());
        }
    }

    abstract int getMaxBorrowLimit();
}
