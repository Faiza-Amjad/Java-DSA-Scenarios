import java.util.Scanner;

public class QueueProgram {

    static int[] queue = new int[5];
    static int front = 0;
    static int rear = -1;
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    static void enqueue() {
        if (count == queue.length) {
            System.out.println("Canteen line is full!");
            return;
        }

        System.out.print("Enter student ID to join the canteen line: ");
        int id = sc.nextInt();

        rear = (rear + 1) % queue.length;
        queue[rear] = id;
        count++;

        System.out.println("Student joined the canteen line.");
    }

    static void dequeue() {
        if (count == 0) {
            System.out.println("No students are waiting in the line!");
            return;
        }

        System.out.println("Student served: " + queue[front]);

        front = (front + 1) % queue.length;
        count--;

        System.out.println("First student removed from the line.");
    }

    static void peek() {
        if (count == 0) {
            System.out.println("Canteen line is empty!");
        } else {
            System.out.println("Next student to be served: "
                    + queue[front]);
        }
    }

    static void display() {
        if (count == 0) {
            System.out.println("Canteen line is empty!");
            return;
        }

        System.out.println("Students in the canteen line:");
        int i = 0;

        while (i < count) {
            int index = (front + i) % queue.length;
            System.out.println(queue[index]);
            i++;
        }
    }

    public static void main(String[] args) {
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n--- College Canteen Queue ---");
            System.out.println("1. Add Student (Enqueue)");
            System.out.println("2. Serve Student (Dequeue)");
            System.out.println("3. View Next Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1: enqueue(); break;
                case 2: dequeue(); break;
                case 3: peek(); break;
                case 4: display(); break;
                case 5: System.out.println("Leaving the canteen system."); break;
                default: System.out.println("Invalid option!");
            }
        }
    }
}