package pkgfinal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TextBook extends Book {
    private String status;

    // Constructor
    public TextBook(String bookId, String publisher, Date entryDate, double unitPrice, double quantity, String status) {
        super(bookId, publisher, entryDate, unitPrice, quantity);
        this.status = status;
    }

    // Getter and Setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void addBook() {
        System.out.println("Text book has been added with ID: " + getBookId());
    }

    @Override
    public void updateBook(String id) {
        if (id.equals(getBookId())) {
            System.out.println("Text book with ID: " + id + " has been updated.");
        } else {
            System.out.println("Book ID not found.");
        }
    }

    @Override
    public void displayBook() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("-------- Text Book --------");
        System.out.println("Book ID: " + getBookId());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("Entry Date: " + dateFormat.format(getEntryDate()));
        System.out.println("Unit Price: " + getUnitPrice());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Status: " + getStatus());
        System.out.println("Discount: " + calculateDiscount());
        System.out.println("Total Amount: " + calculateTotal());
        System.out.println("--------------------------");
    }

    @Override
    public double calculateDiscount() {
        // Calculate discount based on status
        double discount = 0;
        if ("new".equalsIgnoreCase(status)) {
            discount = getQuantity() * getUnitPrice() * 0.10; // 10% discount for new books
        } else if ("old".equalsIgnoreCase(status)) {
            discount = getQuantity() * getUnitPrice() * 0.50; // 50% discount for old books
        }
        return discount;
    }

    @Override
    public double calculateTotal() {
        double discount = calculateDiscount();
        return (getQuantity() * getUnitPrice()) - discount;
    }
}
