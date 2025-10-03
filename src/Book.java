public class Book extends LibraryItem implements Borrowable {
    private String isbn;
    private int numberOfPages;
    private String genre;

    public Book(String itemId, String title, String author, String isbn, int numberOfPages, String genre) {
        super(itemId, title, author);
        this.isbn = isbn;
        setNumberOfPages(numberOfPages);
        setGenre(genre);
    }


    public String getIsbn() { return isbn; }
    public void setGenre(String genre) {
        if (genre != null && !genre.isEmpty()) this.genre = genre;
        else throw new IllegalArgumentException("Genre cannot be empty");
    }

    public void setNumberOfPages(int pages) {
        if (pages <= 0) throw new IllegalArgumentException("Pages must be positive");
        this.numberOfPages = pages;
    }

    @Override
    public String getItemType() {
        return "Book";
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 0.50;
    }

    @Override
    public void borrowItem(String borrowerName) {
        checkOut(borrowerName);
    }

    @Override
    public void returnItem() {
        checkIn();
    }

    @Override
    public boolean isAvailable() {
        return !isCheckedOut;
    }

    @Override
    public int getBorrowingPeriod() {
        return 14; // books are borrowed for 14 days
    }
}

