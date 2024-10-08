package pkgfinal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TextBook extends Book {

    private String status;

    public TextBook(String bookId, String publisher, Date entryDate, double unitPrice, double quantity, String status) {
        super(bookId, publisher, entryDate, unitPrice, quantity);
        this.status = status;
    }

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public double calculateDiscount() {
        return getQuantity() > 10 ? 0.1 : 0.05;
    }

    @Override
    public void addBook() {
        System.out.println("TextBook added.");
        displayBook();
    }

    @Override
    public void updateBook(String id) {
        Scanner scanner = new Scanner(System.in);
        if (getBookId().equals(id)) {
            System.out.println("Updating TextBook ID: " + id);
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
            scanner.nextLine(); // Consume newline
            System.out.println("Enter new Status:");
            setStatus(scanner.nextLine());
            System.out.println("TextBook updated.");
        } else {
            System.out.println("Book ID does not match.");
        }
    }

    @Override
    public void displayBook() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("TextBook ID: " + getBookId());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("Entry Date: " + dateFormat.format(getEntryDate()));
        System.out.println("Unit Price: " + getUnitPrice());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Status: " + getStatus());
    }
}
