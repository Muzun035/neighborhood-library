package com.pluralsight;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class NeighborhoodLibrary {
    private List<Book> books;

    public NeighborhoodLibrary() {
        books = new ArrayList<>();
        initializeBooks();
    }

    // Initialize inventory with 20 books
    private void initializeBooks() {
        books.add(new Book(1, "978-0060934347", "Don Quixote"));
        books.add(new Book(2, "978-0486406510", "A Tale of Two Cities"));
        books.add(new Book(3, "978-0544003415", "The Lord of the Rings"));
        books.add(new Book(4, "978-0156012195", "The Little Prince"));
        books.add(new Book(5, "978-0590353427", "Harry Potter and the Sorcerer's Stone"));
        books.add(new Book(6, "978-0062073488", "And Then There Were None"));
        books.add(new Book(7, "978-0547928227", "The Hobbit"));
        books.add(new Book(8, "978-0385093798", "Dream of the Red Chamber"));
        books.add(new Book(9, "978-0064471046", "The Lion, the Witch and the Wardrobe"));
        books.add(new Book(10, "978-0307474278", "The Da Vinci Code"));
        books.add(new Book(11, "978-0316769488", "The Catcher in the Rye"));
        books.add(new Book(12, "978-0062315007", "The Alchemist"));
        books.add(new Book(13, "978-1508475316", "The Adventures of Sherlock Holmes"));
        books.add(new Book(14, "978-1503290563", "Pride and Prejudice"));
        books.add(new Book(15, "978-0743273565", "The Great Gatsby"));
        books.add(new Book(16, "978-0439023528", "The Hunger Games"));
        books.add(new Book(17, "978-0316015844", "Twilight"));
        books.add(new Book(18, "978-1451635621", "Gone with the Wind"));
        books.add(new Book(19, "978-0375842207", "The Book Thief"));
        books.add(new Book(20, "978-0061120084", "To Kill a Mockingbird"));
    }

    // Display available books
    public void showAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.printf("ID: %d, ISBN: %s, Title: %s%n", book.getId(), book.getIsbn(), book.getTitle());
            }
        }
    }

    // Display checked-out books
    public void showCheckedOutBooks() {
        System.out.println("Checked Out Books:");
        for (Book book : books) {
            if (book.isCheckedOut()) {
                System.out.printf("ID: %d, ISBN: %s, Title: %s, Checked Out To: %s%n",
                        book.getId(), book.getIsbn(), book.getTitle(), book.getCheckedOutTo());
            }
        }
    }

    // Check out a book
    public void checkOutBook(int id, String name) {
        for (Book book : books) {
            if (book.getId() == id && !book.isCheckedOut()) {
                book.checkOut(name);
                System.out.println("Book checked out successfully!");
                return;
            }
        }
        System.out.println("Sorry, the book is not available.");
    }

    // Check in a book
    public void checkInBook(int id) {
        for (Book book : books) {
            if (book.getId() == id && book.isCheckedOut()) {
                book.checkIn();
                System.out.println("Book checked in successfully!");
                return;
            }
        }
        System.out.println("Invalid book ID or the book is not checked out.");
    }

    public static void main(String[] args) {
        NeighborhoodLibrary library = new NeighborhoodLibrary();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Neigborhood Library ---");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.println("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    library.showAvailableBooks();
                    System.out.println("Enter the ID of the book you want to check out (or 0 to go back): ");
                    int checkOutId = scanner.nextInt();
                    scanner.nextLine();
                    if (checkOutId != 0) {
                        System.out.println("Enter your name: ");
                        String name = scanner.nextLine();
                        library.checkOutBook(checkOutId, name);
                    }
                    break;

                case 2:
                    library.showCheckedOutBooks();
                    System.out.println("Enter the ID of the book you want to check in (or 0 to go back): ");
                    int checkedInId = scanner.nextInt();
                    scanner.nextLine();
                    if (checkedInId != 0) {
                        library.checkInBook(checkedInId);
                    }
                    break;
                case 3:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again. ");
            }
        }

        scanner.close();
        System.out.println("Thank you for using the Neighborhood Library!");
    }
}
