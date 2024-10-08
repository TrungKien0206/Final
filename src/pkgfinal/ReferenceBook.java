package pkgfinal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ReferenceBook extends Book {

    private double tax;

    public ReferenceBook(String bookId, String publisher, Date entryDate, double unitPrice, double quantity, double tax) {
        super(bookId, publisher, entryDate, unitPrice, quantity);
        this.tax = tax;
    }

    // Getters and Setters
    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public double calculateDiscount() {
        return getQuantity() * getUnitPrice() * 0.05;

    }

    @Override
    public double calculateTotal() {
        double discount = calculateDiscount();
        return (getQuantity() * getUnitPrice()) + getTax() - discount;    }

    @Override
    public void addBook() {
        System.out.println("ReferenceBook added.");
        displayBook();
    }

    @Override
    public void updateBook(String id) {
        Scanner scanner = new Scanner(System.in);
        if (getBookId().equals(id)) {
            System.out.println("Updating ReferenceBook ID: " + id);
            System.out.println("Enter new Publisher:");
            setPublisher(scanner.nextLine());
            System.out.println("Enter new Entry Date (dd/MM/yyyy):");
            try {
                String dateStr = scanner.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                setEntryDate(dateFormat.parse(dateStr));
            } catch (Exception e) {
                System.out.println("Invalid date format.");
            }
            System.out.println("Enter new Unit Price:");
            setUnitPrice(scanner.nextDouble());
            System.out.println("Enter new Quantity:");
            setQuantity(scanner.nextDouble());
            System.out.println("Enter new Tax:");
            setTax(scanner.nextDouble());
            System.out.println("ReferenceBook updated.");
        } else {
            System.out.println("Book ID does not match.");
        }
    }

    @Override
    public void displayBook() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("ReferenceBook ID: " + getBookId());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("Entry Date: " + dateFormat.format(getEntryDate()));
        System.out.println("Unit Price: " + getUnitPrice());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Tax: " + getTax());
    }
}
