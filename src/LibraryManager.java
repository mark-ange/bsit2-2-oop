import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private List<Borrowable> items;

    public LibraryManager() {
        this.items = new ArrayList<>();
    }

    public void addItem(Borrowable item) {
        items.add(item);
        System.out.println("Added: " + ((LibraryItem)item).getTitle());
    }

    public void displayAllItems() {
        System.out.println("\n--- All Library Items ---");
        if (items.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }
        for (Borrowable item : items) {
            LibraryItem libraryItem = (LibraryItem) item;
            System.out.println("[" + libraryItem.getItemType() + "] " + libraryItem.getItemInfo());
        }
    }

    public Borrowable findItem(String itemId) {
        for (Borrowable item : items) {
            if (((LibraryItem) item).getItemId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }

    public Borrowable borrowItem(String itemId, User user) {
        Borrowable item = findItem(itemId);

        if (item == null) {
            System.out.println("Error: Item with ID " + itemId + " not found.");
            return null;
        }

        LibraryItem libraryItem = (LibraryItem) item;

        if (!item.isAvailable()) {
            System.out.println("Error: " + libraryItem.getTitle() + " is currently borrowed by " + libraryItem.getBorrowerName() + ".");
            return null;
        }

        if (user.getBorrowedItemsCount() >= user.getMaxBorrowLimit()) {
            System.out.println("Error: " + user.getName() + " has reached the maximum borrow limit of " + user.getMaxBorrowLimit() + " items.");
            return null;
        }

        item.borrowItem(user.getName());
        user.addBorrowedItem(libraryItem);
        return item;
    }

    public Borrowable returnItem(String itemId, User user) {
        Borrowable item = findItem(itemId);

        if (item == null) {
            return null;
        }

        LibraryItem libraryItem = (LibraryItem) item;

        if (libraryItem.isCheckedOut() && libraryItem.getBorrowerName().equals(user.getName())) {
            item.returnItem();
            user.removeBorrowedItem(libraryItem);
            return item;
        } else {
            System.out.println("Error: " + libraryItem.getTitle() + " is not currently borrowed by " + user.getName() + ".");
            return null;
        }
    }

    public void displayAvailableItems() {
        System.out.println("\n--- Available Library Items ---");
        boolean found = false;
        for (Borrowable item : items) {
            if (item.isAvailable()) {
                LibraryItem libraryItem = (LibraryItem) item;
                System.out.println("  - [" + libraryItem.getItemType() + "] " + libraryItem.getTitle() + " (ID: " + libraryItem.getItemId() + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items are currently available for borrowing.");
        }
    }

    public double calculateTotalLateFees(int daysLate) {
        double totalFee = 0.0;
        System.out.println("\n--- Late Fee Calculation (Assuming " + daysLate + " days late) ---");
        for (Borrowable item : items) {
            LibraryItem libraryItem = (LibraryItem) item;
            double fee = libraryItem.calculateLateFee(daysLate);
            System.out.printf("  - %s (%s): $%.2f%n", libraryItem.getTitle(), libraryItem.getItemType(), fee);
            totalFee += fee;
        }
        return totalFee;
    }
}
