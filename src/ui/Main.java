package ui;

import java.util.Scanner;
import service.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        runMenu(service);
    }

    private static void runMenu(StudentService service) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            showMenu();
            System.out.print("Enter choice: ");
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    service.addStudent();
                    break;
                case 2:
                    service.deleteStudent();
                    break;
                case 3:
                    service.searchStudent();
                    break;
                case 4:
                    service.displayAll();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void showMenu() {
        System.out.println("===== MENU =====");
        System.out.println("1. Add student");
        System.out.println("2. Delete student");
        System.out.println("3. Search by name");
        System.out.println("4. Display all");
        System.out.println("0. Exit");
    }
}
