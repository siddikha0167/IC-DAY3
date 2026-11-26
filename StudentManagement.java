import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of Students: ");
        int n = sc.nextInt();

        int[] ids = new int[n];
        String[] names = new String[n];
        String[] departments = new String[n];

        int[][] marks = new int[n][5];

        int[] totals = new int[n];
        double[] averages = new double[n];
        String[] grades = new String[n];

        int topperIndex = 0;

        for (int i = 0; i < n; i++) {

            System.out.println("\n===== Student " + (i + 1) + " =====");

            System.out.print("Enter Student ID: ");
            ids[i] = sc.nextInt();

            System.out.print("Enter Student Name: ");
            names[i] = sc.next();

            System.out.print("Enter Department: ");
            departments[i] = sc.next();

            totals[i] = 0;

            for (int j = 0; j < 5; j++) {
                System.out.print("Enter Subject " + (j + 1) + " Marks: ");
                marks[i][j] = sc.nextInt();
                totals[i] += marks[i][j];
            }

            averages[i] = totals[i] / 5.0;

            if (averages[i] >= 90)
                grades[i] = "A+";
            else if (averages[i] >= 80)
                grades[i] = "A";
            else if (averages[i] >= 70)
                grades[i] = "B";
            else if (averages[i] >= 60)
                grades[i] = "C";
            else if (averages[i] >= 50)
                grades[i] = "D";
            else
                grades[i] = "F";

            if (averages[i] > averages[topperIndex]) {
                topperIndex = i;
            }
        }

        System.out.println("\n================ ALL STUDENT DETAILS ================");

        for (int i = 0; i < n; i++) {

            System.out.println("\n----------------------------------");
            System.out.println("Student ID      : " + ids[i]);
            System.out.println("Student Name    : " + names[i]);
            System.out.println("Department      : " + departments[i]);

            for (int j = 0; j < 5; j++) {
                System.out.println("Subject " + (j + 1) + " Marks : " + marks[i][j]);
            }

            System.out.println("Total           : " + totals[i]);
            System.out.println("Average         : " + averages[i]);
            System.out.println("Grade           : " + grades[i]);
            System.out.println("Result          : "
                    + (averages[i] >= 50 ? "PASS" : "FAIL"));
        }

        System.out.println("\n================ TOPPER DETAILS =================");

        System.out.println("Student ID   : " + ids[topperIndex]);
        System.out.println("Student Name : " + names[topperIndex]);
        System.out.println("Department   : " + departments[topperIndex]);
        System.out.println("Total Marks  : " + totals[topperIndex]);
        System.out.println("Average      : " + averages[topperIndex]);
        System.out.println("Grade        : " + grades[topperIndex]);

        sc.close();
    }
}