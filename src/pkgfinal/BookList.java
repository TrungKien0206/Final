package pkgfinal;

import java.util.ArrayList;
import java.util.Scanner;

public class BookList {
    private ArrayList<Book> bookList;

    public BookList() {
        bookList = new ArrayList<>();
    }

    // Add book
    public void addBook(Book book) {
        bookList.add(book);
        System.out.println("Book added successfully!");
    }

    // Update book by ID
    public void updateBook(String id) {
        for (Book book : bookList) {
            if (book.getBookId().equals(id)) {
                book.updateBook(id);
                return;
            }
        }
        System.out.println("Book ID not found.");
    }

    // Delete book by ID
    public void deleteBookById(String id) {
        bookList.removeIf(book -> book.getBookId().equals(id));
        System.out.println("Book deleted successfully.");
    }

    // Find book by ID
    public Book findBookById(String id) {
        for (Book book : bookList) {
            if (book.getBookId().equals(id)) {
                return book;
            }
        }
        System.out.println("Book not found.");
        return null;
    }

    // Display all books
    public void displayAllBooks() {
        for (Book book : bookList) {
            book.displayBook();
            System.out.println("-----------------------------");
        }
    }

    // Calculate total amount of all books
    public double calculateTotalAmount() {
        double total = 0;
        for (Book book : bookList) {
            total += book.calculateTotal();
        }
        return total;
    }
}
