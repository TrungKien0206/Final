
package pkgfinal;
import java.util.Date;

public class TextBook extends Book {
    private String status;

    public TextBook(String bookId, String publisher, Date entryDate, double unitPrice, double quantity, String status) {
        super(bookId, publisher, entryDate, unitPrice, quantity);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void addBook() {
        System.out.println("Adding TextBook: " + getBookId());
    }

    @Override
    public void updateBook(String id) {
        System.out.println("Updating TextBook with ID: " + id);
    }

    @Override
    public void displayBook() {
        System.out.println("TextBook ID: " + getBookId() + ", Publisher: " + getPublisher() +
                ", Entry Date: " + getEntryDate() + ", Unit Price: " + getUnitPrice() +
                ", Quantity: " + getQuantity() + ", Status: " + getStatus());
    }
}
