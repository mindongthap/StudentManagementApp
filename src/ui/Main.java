package ui;

import model.Student;
import service.StudentService;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add student");
            System.out.println("2. Delete student");
            System.out.println("3. Search by name");
            System.out.println("4. Display all");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter full name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter GPA: ");
                        double gpa = Double.parseDouble(sc.nextLine());

                        Student s = new Student(id, name, gpa);
                        if (service.addStudent(s)) {
                            System.out.println("Student added.");
                        } else {
                            System.out.println("Invalid input or duplicate ID.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: Please enter valid input.");
                    }
                    break;

                case 2:
                    System.out.print("Enter ID to delete: ");
                    int delId = Integer.parseInt(sc.nextLine());
                    if (service.deleteStudent(delId)) {
                        System.out.println("Student deleted.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    ArrayList<Student> result = service.searchByName(searchName);

                    if (result.isEmpty()) {
                        System.out.println("No student found.");
                    } else {
                        for (Student s : result) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 4:
                    service.displayAll();
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
