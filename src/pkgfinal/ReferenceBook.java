
package pkgfinal;

import java.util.Date;

public class ReferenceBook extends Book {
    private double tax;

    public ReferenceBook(String bookId, String publisher, Date entryDate, double unitPrice, double quantity, double tax) {
        super(bookId, publisher, entryDate, unitPrice, quantity);
        this.tax = tax;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public void addBook() {
        System.out.println("Adding ReferenceBook: " + getBookId());
    }

    @Override
    public void updateBook(String id) {
        System.out.println("Updating ReferenceBook with ID: " + id);
    }

    @Override
    public void displayBook() {
        System.out.println("ReferenceBook ID: " + getBookId() + ", Publisher: " + getPublisher() +
                ", Entry Date: " + getEntryDate() + ", Unit Price: " + getUnitPrice() +
                ", Quantity: " + getQuantity() + ", Tax: " + getTax());
    }
}
