package pkgfinal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Processor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookList bookList = new BookList();

        int option = -1;

        do {
            System.out.println("1. Add new book");
            System.out.println("2. Update book by id");
            System.out.println("3. Delete book by id");
            System.out.println("4. Find book by id");
            System.out.println("5. Display all books");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.println("Enter book details:");
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter Publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.print("Enter Entry Date (dd/MM/yyyy): ");
                    Date entryDate = null;
                    try {
                        entryDate = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Invalid date format.");
                    }
                    System.out.print("Enter Unit Price: ");
                    double unitPrice = scanner.nextDouble();
                    System.out.print("Enter Quantity: ");
                    double quantity = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    System.out.println("Enter Book Type: ");
                    System.out.println("1. TextBook");
                    System.out.println("2. ReferenceBook");
                    int type = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Book book = null;

                    if (type == 1) {
                        System.out.print("Enter Status: ");
                        String status = scanner.nextLine();
                        book = new TextBook(bookId, publisher, entryDate, unitPrice, quantity, status);
                    } else if (type == 2) {
                        System.out.print("Enter Tax: ");
                        double tax = scanner.nextDouble();
                        book = new ReferenceBook(bookId, publisher, entryDate, unitPrice, quantity, tax);
                    }

                    if (book != null) {
                        bookList.addBook(book);
                    }
                    break;

                case 2:
                    System.out.print("Enter Book ID to update: ");
                    String updateId = scanner.nextLine();
                    bookList.updateBook(updateId);
                    break;

                case 3:
                    System.out.print("Enter Book ID to delete: ");
                    String deleteId = scanner.nextLine();
                    bookList.deleteBookById(deleteId);
                    break;

                case 4:
                    System.out.print("Enter Book ID to find: ");
                    String findId = scanner.nextLine();
                    Book foundBook = bookList.findBookById(findId);
                    if (foundBook != null) {
                        foundBook.displayBook();
                    }
                    break;

                case 5:
                    bookList.displayAllBooks();
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 6);

        scanner.close();
    }
}
