package pkgfinal;

import java.util.ArrayList;
import java.util.Scanner;

public class BookList {
    private ArrayList<Book> bookList;

    public BookList() {
        bookList = new ArrayList<>();
    }

    public void addBook(Book book) {
        bookList.add(book);
        System.out.println("Book added successfully!");
    }

    public void updateBook(String id) {
        for (Book book : bookList) {
            if (book.getBookId().equals(id)) {
                book.updateBook(id);
                return;
            }
        }
        System.out.println("Book ID not found.");
    }

    public void deleteBookById(String id) {
        bookList.removeIf(book -> book.getBookId().equals(id));
        System.out.println("Book deleted successfully.");
    }

    public Book findBookById(String id) {
        for (Book book : bookList) {
            if (book.getBookId().equals(id)) {
                return book;
            }
        }
        System.out.println("Book not found.");
        return null;
    }

    public void displayAllBooks() {
        for (Book book : bookList) {
            book.displayBook();
            System.out.println("-----------------------------");
        }
    }

    public double calculateTotalAmount() {
        double total = 0;
        for (Book book : bookList) {
            total += book.calculateTotal();
        }
        return total;
    }
}
