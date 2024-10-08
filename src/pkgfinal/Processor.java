package pkgfinal;

import java.util.Date;
import java.util.Scanner;

public class Processor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookList bookList = new BookList();

        while (true) {
            System.out.println("1. Add New Book"
                    + "\n2. Update Book by ID"
                    + "\n3. Delete Book by ID"
                    + "\n4. Find Book by ID"
                    + "\n5. Display All Books"
                    + "\n6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Book ID:");
                    String bookId = scanner.nextLine();
                    System.out.println("Enter Publisher:");
                    String publisher = scanner.nextLine();
                    System.out.println("Enter Entry Date (dd/MM/yyyy):");
                    String dateStr = scanner.nextLine();
                    Date entryDate = new Date(); // Parsing date logic can be added here
                    System.out.println("Enter Unit Price:");
                    double unitPrice = scanner.nextDouble();
                    System.out.println("Enter Quantity:");
                    double quantity = scanner.nextDouble();
                    System.out.println("Enter Status (for TextBook only):");
                    String status = scanner.nextLine();
                    System.out.println("Enter Tax (for ReferenceBook only):");
                    double tax = scanner.nextDouble();

                    bookList.addBook(new TextBook(bookId, publisher, entryDate, unitPrice, quantity, status));
                    break;
                case 2:
                    System.out.println("Enter Book ID to update:");
                    String updateId = scanner.nextLine();
                    bookList.updateBook(updateId);
                    break;
                case 3:
                    System.out.println("Enter Book ID to delete:");
                    String deleteId = scanner.nextLine();
                    bookList.deleteBookById(deleteId);
                    break;
                case 4:
                    System.out.println("Enter Book ID to find:");
                    String findId = scanner.nextLine();
                    bookList.findBookById(findId);
                    break;
                case 5:
                    bookList.displayAllBooks();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
