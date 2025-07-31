import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.print("Enter Student ID: ");
        String studentId = input.nextLine();

        System.out.print("Enter First Name: ");
        String firstName = input.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = input.nextLine();

        System.out.print("Enter Course: ");
        String course = input.nextLine();

        System.out.print("Enter Section: ");
        String section = input.nextLine();


        System.out.println("\nSTUDENT INFORMATION");
        System.out.println("Student Id: " + studentId);
        System.out.println("Student name: " + firstName + " " + lastName);
        System.out.println("Course: " + course);
        System.out.println("Section: " + section);


        System.out.print("\nEnter Midterm Exam Score: ");
        int midtermScore = input.nextInt();

        System.out.print("Enter Final Exam Score: ");
        int finalScore = input.nextInt();

        System.out.print("Enter Project Score: ");
        int projectScore = input.nextInt();

        System.out.print("Enter Attendance Percentage: ");
        int attendanceScore = input.nextInt();


        int allOverScore = midtermScore + finalScore + projectScore + attendanceScore;
        double averageScore = (allOverScore / 400.0) * 100;


        String remarks;
        if (averageScore < 75) {
            remarks = "FAILED";
        } else {
            remarks = "PASSED";
        }

        System.out.println("\nSTUDENT SCORE");
        System.out.println("Midterm Exam Score: " + midtermScore);
        System.out.println("Final Exam Score: " + finalScore);
        System.out.println("Project Score: " + projectScore);
        System.out.println("Attendance Score: " + attendanceScore);
        System.out.printf("\nAverage Score: %.2f\n", averageScore);
        System.out.println("Remarks: " + remarks);

        input.close();
    }
}
