import java.util.Scanner;
import java.text.DecimalFormat;

public class Task2 {
    public static void main(String srgs[]) {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+             WELCOME TO GRADE CALCULATOR               +");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Student Name : ");
            String name = sc.nextLine();
            System.out.print("Enter Roll no  : ");
            int roll = sc.nextInt();

            System.out.println("\n-------------------------------------------------------\n");
            System.out.print("Enter Number Of Subjects : ");
            int n = sc.nextInt();
            System.out.println();

            double marks[] = new double[n];
            String sub[] = new String[n];
            double total = 0;
            int Fail = 0;
            String result = "Pass";

            for (int i = 0; i < n; i++) {
                System.out.print((i + 1) + ". Enter Subject Name  : ");
                sub[i] = sc.next();
                System.out.print("   Enter " + sub[i] + " Mark(out of 100) : ");
                marks[i] = sc.nextDouble();
                System.out.println();
                if (marks[i] < 35) {
                    Fail++;
                }
                total = total + marks[i];
                while(marks[i]>100){
                    System.out.println("    -------Invalid Marks------- ");
                    System.out.println("    Enter Valid Marks : ");
                    marks[i] = sc.nextDouble();
                }

            }

            double average = 0;
            if (Fail == 0) {
                average = total / n;
            } else {
                result = "Fail";
            }
            DecimalFormat df = new DecimalFormat("#.##");

            System.out.println("\n=======================================================");
            System.out.println("                  Result Of Student ");
            System.out.println("=======================================================\n");

            String grade = "";
            if (result == "Pass") {
                if (average > 90 && average <= 100) {
                    grade = "A+";
                } else if (average < 90 && average >= 80) {
                    grade = "A";
                } else if (average < 80 && average >= 70) {
                    grade = "B+";
                } else if (average < 70 && average >= 60) {
                    grade = "B";
                } else if (average < 60 && average >= 50) {
                    grade = "C+";
                } else if (average < 50 && average >= 40) {
                    grade = "C";
                } else if (average < 40 && average >= 35) {
                    grade = "D";
                }
            }

            System.out.println("Name : " + name + "\nRoll no. : " + roll + "\nResult : " + result);
            if (result == "Pass") {
                System.out.println("-------------------------------------------------------");
                System.out.println("Subject\t\t\tMax Marks \tObtained Marks");
                System.out.println("-------------------------------------------------------");
                for (int i = 0; i < n; i++) {
                    System.out.println(sub[i] + "\t\t\t100 \t\t" + marks[i]);
                }
                System.out.println("-------------------------------------------------------");
                System.out.println("Total Marks\t\t" + (n * 100) + "\t\t" + total);
                System.out.println("\nPercentage : " + (df.format(average)) + "%\t\tGrade : " + grade);

            }

            System.out.println("\n=======================================================");
            System.out.println("\n=======================================================\n");
            sc.close();

        } catch (Exception e) {
            System.out.println("Error " + e);
        }

    }
}
