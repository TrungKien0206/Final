package pkgfinal;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Book implements IBook {

    private String bookId;
    private String publisher;
    private Date entryDate;
    private double unitPrice;
    private double quantity;

    public Book(String bookId, String publisher, Date entryDate, double unitPrice, double quantity) {
        this.bookId = bookId;
        this.publisher = publisher;
        this.entryDate = entryDate;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getBookId() {
        return bookId;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    // Abstract methods
    public abstract double calculateDiscount();

    @Override
    public abstract void addBook();

    @Override
    public abstract void updateBook(String id);

    @Override
    public abstract void displayBook();

    @Override
    public double calculateTotal() {
        return getUnitPrice() * getQuantity() * (1 - calculateDiscount());
    }
}
