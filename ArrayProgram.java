import java.util.Scanner;

public class ArrayProgram {

    static int[] books = new int[5];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    static void addBook() {
        if (count == books.length) {
            System.out.println("Bookshelf is full!");
            return;
        }

        System.out.print("Enter book ID to place on bookshelf: ");
        books[count] = sc.nextInt();
        count++;

        System.out.println("Book added to the library bookshelf.");
    }

    static void displayBooks() {
        if (count == 0) {
            System.out.println("Bookshelf is empty!");
            return;
        }

        System.out.println("Book IDs on the library bookshelf:");
        int i = 0;

        while (i < count) {
            System.out.println(books[i]);
            i++;
        }
    }

    static int searchBook(int id) {
        int i = 0;

        while (i < count) {
            if (books[i] == id) {
                return i;
            }
            i++;
        }

        return -1;
    }

    static void search() {
        System.out.print("Enter book ID to find on bookshelf: ");
        int id = sc.nextInt();

        if (searchBook(id) != -1) {
            System.out.println("Book found on the bookshelf.");
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    static void updateBook() {
        System.out.print("Enter book ID to update: ");
        int id = sc.nextInt();

        int index = searchBook(id);

        if (index == -1) {
            System.out.println("Book not found.");
            return;
        }

        System.out.print("Enter new book ID: ");
        books[index] = sc.nextInt();

        System.out.println("Book ID updated on the bookshelf.");
    }

    static void deleteBook() {
        System.out.print("Enter book ID to remove from bookshelf: ");
        int id = sc.nextInt();

        int index = searchBook(id);

        if (index == -1) {
            System.out.println("Book not found.");
            return;
        }

        int i = index;

        while (i < count - 1) {
            books[i] = books[i + 1];
            i++;
        }

        count--;

        System.out.println("Book removed from the bookshelf.");
    }

    public static void main(String[] args) {
        int choice = 0;

        while (choice != 6) {
            System.out.println("\n--- Library Bookshelf ---");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book ID");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1: addBook(); break;
                case 2: displayBooks(); break;
                case 3: search(); break;
                case 4: updateBook(); break;
                case 5: deleteBook(); break;
                case 6: System.out.println("Leaving the library system."); break;
                default: System.out.println("Invalid option!");
            }
        }
    }
}