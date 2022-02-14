import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int id;
        String name;
        int mathGrade;
        int dataGrade;

        LinkedList<Student> students = new LinkedList<>();

        try {
            File file = new File("C:\\Users\\asus\\Downloads\\students.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(" ");
                Student ogrenci = new Student(Integer.parseInt(split[0]), split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]));
                students.insert(ogrenci);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("-");
        }
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("0- Exit.");
            System.out.println("1- Display the linked list content.");
            System.out.println("2- Display the students sorted by their overall average.");
            System.out.println("3- Display the student names sorted by their data structure grades.");
            System.out.println("4- Find and display the math average.");
            System.out.println("5- Find and display the student(s) who has the lowest Data Structures grade. ");
            System.out.println("6- Delete the student.");
            System.out.println("7- insert a new student.");

            System.out.print("seçiminiz: ");
            int secim = scanner.nextInt();
            System.out.println("**********************************************************************************");

            if (secim == 0) {
                break;

            } else if (secim == 1) {
                students.display();
                System.out.println("Number of registered students: " + students.size());

            } else if (secim == 2) {
                Student.setCompare("Overall average");
                students.sort();
                students.display();

            } else if (secim == 3) {
                Student.setCompare("Data Structures");
                students.sort();
                students.display();

            } else if (secim == 4) {
                System.out.println("Math average: " + Student.mathAverage(students, "math average"));

            } else if (secim == 5) {
                System.out.println("Lowest data structures course score: ");Student.lowestDataGrade(students, "lowest data structures").display();

            } else if (secim == 6) {
                System.out.print("Enter the student ID you want to delete: ");id = scanner.nextInt();
                scanner.nextLine();
                Student ogrenci = Student.findTheStudent(students, id);
                students.delete(ogrenci);
                System.out.println("Number of registered students: " + students.size());
            }
            else if (secim == 7) {

                System.out.print("Enter the student ID: ");id = scanner.nextInt();
                scanner.nextLine();
                if (Student.findTheStudent(students, id) == null) {
                    System.out.print("Enter the student name: ");name = scanner.next();
                    System.out.print("Enter the student data structures grade: ");dataGrade = scanner.nextInt();
                    System.out.print("Enter the student math grade: ");mathGrade = scanner.nextInt();
                    Student ogrenci = new Student(id, name, dataGrade, mathGrade);
                    students.insert(ogrenci);
                } else {
                    System.out.println("The student already exists.");
                }
                System.out.println("Number of registered students: " + students.size());
            }
            System.out.println("**********************************************************************************");
            scanner.nextLine();
            System.out.println("");
        } while (true);
        scanner.close();
    }
}

