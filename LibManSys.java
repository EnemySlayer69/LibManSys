import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    String title;
    String author;
    String isbn;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn;
    }
}

class Library {
    private List<Book> books;

    Library() {
        books = new ArrayList<>();
    }

    void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    void removeBook(String isbn) {
        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                books.remove(book);
                System.out.println("Book removed successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    void searchBook(String isbn) {
        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                System.out.println("Book found: " + book);
                return;
            }
        }
        System.out.println("Book not found!");
    }

    void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Library Books:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}

public class LibManSys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    Book book = new Book(title, author, isbn);
                    library.addBook(book);
                    break;

                case 2:
                    System.out.print("Enter book ISBN to remove: ");
                    isbn = scanner.nextLine();
                    library.removeBook(isbn);
                    break;

                case 3:
                    System.out.print("Enter book ISBN to search: ");
                    isbn = scanner.nextLine();
                    library.searchBook(isbn);
                    break;

                case 4:
                    library.displayBooks();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
