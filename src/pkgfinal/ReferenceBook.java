package pkgfinal;

import java.text.SimpleDateFormat;
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
        System.out.println("Reference book has been added with ID: " + getBookId());
    }

    @Override
    public void updateBook(String id) {
        if (id.equals(getBookId())) {
            System.out.println("Reference book with ID: " + id + " has been updated.");
        } else {
            System.out.println("Book ID not found.");
        }
    }

    @Override
    public void displayBook() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("-------- Reference Book --------");
        System.out.println("Book ID: " + getBookId());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("Entry Date: " + dateFormat.format(getEntryDate()));
        System.out.println("Unit Price: " + getUnitPrice());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Tax: " + getTax());
        System.out.println("Discount: " + calculateDiscount());
        System.out.println("Total Amount: " + calculateTotal());
        System.out.println("--------------------------------");
    }

    @Override
    public double calculateDiscount() {
        return getQuantity() * getUnitPrice() * 0.05;
    }

    @Override
    public double calculateTotal() {
        double discount = calculateDiscount();
        return (getQuantity() * getUnitPrice()) + getTax() - discount;
    }
}
