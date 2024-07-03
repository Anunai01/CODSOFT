package internshipProjects;

import java.util.Scanner;
import java.text.DecimalFormat;

public class gradeCalculator {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO STUDENT GRADE CALCULATOR !! ");
        System.out.print("Enter the number of subjects: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the subjects with their marks: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Subject name: " );
            String str= sc.next();
            System.out.print(" MARKS OUT OF 100: ");
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        double tot_marks = n * 100;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }
        System.out.print("OBTAINED MARKS: " + (sum) + " out of " +(int)(tot_marks) ); // MARKS OBTAINED

        double avg_percent = (sum / tot_marks) * 100;
        System.out.println();
        System.out.println("AVERAGE PERCENTAGE IS " + df.format(avg_percent) + "%"); // AVERAGE PERCENTAGE
        // FOR GRADES
        if (  avg_percent >= 90) {
            System.out.println("GRADE: A+");
            System.out.println("EXCELLENT !!");}
        else if ( avg_percent>70 && avg_percent <= 80) {
            System.out.println("GRADE: A");
            System.out.println("BEST !!");
        } else if (70 <= avg_percent && avg_percent < 80) {
            System.out.println("GRADE: B");
            System.out.println("GOOD !!");
        } else if (60 <= avg_percent && avg_percent < 70) {
            System.out.println("GRADE: C");
            System.out.println("CAN DO BETTER !!");
        } else if (50 <= avg_percent && avg_percent < 60) {
            System.out.println("GRADE: D");
            System.out.println("WORK HARD !!");
        }
        else if (40 <= avg_percent && avg_percent < 50) {
            System.out.println("GRADE: E");
            System.out.println("BAD PERFORMANCE !!");
        }
        else if ( avg_percent < 40) {
            System.out.println("GRADE: F");
            System.out.println("FAIL !!");
        }
    }
}
