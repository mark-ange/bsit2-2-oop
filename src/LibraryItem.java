 public abstract class LibraryItem {
    protected String itemId;
    protected String title;
    protected String author;
    protected boolean isCheckedOut = false;
    protected String borrowerName;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemInfo() {
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }

    public void checkOut(String borrowerName) {
        this.isCheckedOut = true;
        this.borrowerName = borrowerName;
    }

    public void checkIn() {
        this.isCheckedOut = false;
        this.borrowerName = null;
    }

    public abstract String getItemType();
    public abstract double calculateLateFee(int daysLate);
}