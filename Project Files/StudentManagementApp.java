import java.util.*;

public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n--- Student Result Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();
                    Student s = new Student(id, name, marks);
                    dao.addStudent(s);
                    break;
                case 2:
                    List<Student> students = dao.getAllStudents();
                    for (Student st : students) {
                        System.out.printf("ID: %d | Name: %s | Marks: %d | Grade: %s\n",
                                st.getId(), st.getName(), st.getMarks(), st.getGrade());
                    }
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}