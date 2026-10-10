import java.util.Scanner;

public class StackProgram {

    static int[] stack = new int[5];
    static int top = -1;
    static Scanner sc = new Scanner(System.in);

    static void push() {
        if (top == stack.length - 1) {
            System.out.println("Book stack is full!");
            return;
        }

        System.out.print("Enter book ID to place on top of the stack: ");
        int id = sc.nextInt();

        top++;
        stack[top] = id;

        System.out.println("Book placed on top of the stack.");
    }

    static void pop() {
        if (top == -1) {
            System.out.println("Book stack is empty!");
            return;
        }

        System.out.println("Removed book ID: " + stack[top]);
        top--;

        System.out.println("Top book removed from the stack.");
    }

    static void peek() {
        if (top == -1) {
            System.out.println("No books on the stack.");
        } else {
            System.out.println("Book ID at the top: " + stack[top]);
        }
    }

    static void display() {
        if (top == -1) {
            System.out.println("Book stack is empty!");
            return;
        }

        System.out.println("Books from top to bottom:");
        int i = top;

        while (i >= 0) {
            System.out.println(stack[i]);
            i--;
        }
    }

    public static void main(String[] args) {
        Scanner input = sc;
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n--- Stack of Books ---");
            System.out.println("1. Push Book");
            System.out.println("2. Pop Book");
            System.out.println("3. View Top Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            choice = input.nextInt();

            switch (choice) {
                case 1: push(); break;
                case 2: pop(); break;
                case 3: peek(); break;
                case 4: display(); break;
                case 5: System.out.println("Leaving the book stack."); break;
                default: System.out.println("Invalid option!");
            }
        }
    }
}