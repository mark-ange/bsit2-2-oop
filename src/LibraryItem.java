abstract class LibraryItem {

    protected String itemId;
    protected String title;
    protected String author;
    protected boolean isCheckedOut;
    protected String borrowerName;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
        this.borrowerName = null;
    }

    public String getItemInfo() {
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author +
                ", Status: " + (isCheckedOut ? "Borrowed by " + borrowerName : "Available");
    }

    public void checkOut(String borrowerName) {
        if (!isCheckedOut) {
            this.isCheckedOut = true;
            this.borrowerName = borrowerName;
        } else {
            System.out.println(title + " is already checked out by " + this.borrowerName + ".");
        }
    }

    public void checkIn() {
        if (isCheckedOut) {
            this.isCheckedOut = false;
            this.borrowerName = null;
        } else {
            System.out.println(title + " is already available.");
        }
    }

    public abstract String getItemType();
    public abstract double calculateLateFee(int daysLate);

    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isCheckedOut() { return isCheckedOut; }
    public String getBorrowerName() { return borrowerName; }
}