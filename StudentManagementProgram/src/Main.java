import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<String> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("STUDENT MANAGEMENT");
            System.out.println("1. Enter student list");
            System.out.println("2. Find students by last name");
            System.out.println("3. Find and edit students by full name");
            System.out.println("4. End");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    enterStudentList(scanner);
                    break;
                case 2:
                    findStudentsByLastName();
                    break;
                case 3:
                    findAndEditStudentsByFullName();
                    break;
                case 4:
                    System.out.println("Program ended.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void enterStudentList(Scanner scanner) {
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter the full name of student " + (i + 1) + ": ");
            String fullName = scanner.nextLine();
            studentList.add(fullName);
        }

        System.out.println("Student list entered successfully.");
        System.out.println();
    }

    private static void findStudentsByLastName() { // Scanner scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the last name to search for: ");
        String lastName = scanner.nextLine();

        List<String> matchingStudents = new ArrayList<>();
        for (String fullName : studentList) {
            String[] names = fullName.split(" ");
            if (names.length > 0 && names[names.length - 1].equalsIgnoreCase(lastName)) {
                matchingStudents.add(fullName);
            }
        }

        if (matchingStudents.isEmpty()) {
            System.out.println("No students found with the last name '" + lastName + "'.");
        } else {
            System.out.println("Students with the last name '" + lastName + "':");
            for (String student : matchingStudents) {
                System.out.println(student);
            }
        }

        System.out.println();
    }

    private static void findAndEditStudentsByFullName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the full name of the student to edit: ");
        String fullName = scanner.nextLine();

        int index = -1;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).equalsIgnoreCase(fullName)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Student with the full name '" + fullName + "' not found.");
        } else {
            System.out.print("Enter the new full name for student " + (index + 1) + ": ");
            String newFullName = scanner.nextLine();
            studentList.set(index, newFullName);
            System.out.println("Student updated successfully.");
        }

        System.out.println();
    }
}