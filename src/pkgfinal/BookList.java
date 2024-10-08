
package pkgfinal;

import java.util.ArrayList;

public class BookList {
    private ArrayList<Book> personList;

    public BookList() {
        this.personList = new ArrayList<>();
    }

    public void addBook(Book book) {
        personList.add(book);
        book.addBook();
    }

    public void updateBook(String id) {
        for (Book book : personList) {
            if (book.getBookId().equals(id)) {
                book.updateBook(id);
            }
        }
    }

    public void deleteBookById(String id) {
        personList.removeIf(book -> book.getBookId().equals(id));
        System.out.println("Deleted Book with ID: " + id);
    }

    public void findBookById(String id) {
        for (Book book : personList) {
            if (book.getBookId().equals(id)) {
                book.displayBook();
                return;
            }
        }
        System.out.println("Book not found with ID: " + id);
    }

    public void displayAllBooks() {
        for (Book book : personList) {
            book.displayBook();
        }
    }
}
