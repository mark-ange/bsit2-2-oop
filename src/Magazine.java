public class Magazine extends LibraryItem implements Borrowable {

    private int issueNumber;
    private String publicationMonth;
    private boolean isLatestIssue;

    public Magazine(String itemId, String title, String author, int issueNumber, String publicationMonth, boolean isLatestIssue) {
        super(itemId, title, author);
        setIssueNumber(issueNumber);
        this.publicationMonth = publicationMonth;
        this.isLatestIssue = isLatestIssue;
    }

    public int getIssueNumber() { return issueNumber; }
    public String getPublicationMonth() { return publicationMonth; }
    public boolean isLatestIssue() { return isLatestIssue; }

    public void setIssueNumber(int issueNumber) {
        if (issueNumber <= 0) {
            System.out.println("Magazine: Issue number must be positive. Setting to 1.");
            this.issueNumber = 1;
        } else {
            this.issueNumber = issueNumber;
        }
    }

    public void setIsLatestIssue(boolean isLatestIssue) {
        this.isLatestIssue = isLatestIssue;
    }

    @Override
    public String getItemType() {
        return "Magazine";
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 0.25;
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
        return 7;
    }

    @Override
    public String getItemInfo() {
        return super.getItemInfo() + ", Type: Magazine, Issue: " + issueNumber +
                ", Month: " + publicationMonth + ", Latest: " + isLatestIssue;
    }
}