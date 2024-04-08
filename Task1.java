import java.io.FileInputStream;
import java.util.*;

public class Task1 {
    public static void main(String args[]) {
        int c;
        Scanner sc;
        try {
            //separately make welcome text file for design purpose only
            FileInputStream wel = new FileInputStream("welcome.txt");
            while (true) {
                c = wel.read();
                if (c == -1)
                    break;
                System.out.print((char) c);

            }
            sc = new Scanner(System.in);
            System.out.print("\nEnter Your Name : ");
            String name = sc.nextLine();
            System.out.println("\nHey " + name + ", Welcome To Number Game ");

            System.out.println("=============================================================================\n");
            System.out.println(
                    "INSTRCTIONS  :\n >>  The system will generate a random number between 1 and 100.\n >>  You have 10 attempts to guess it.\n >>  Your score will be the number of attempts you took to guess the number.\n >>  Try to guess the random number accurately within the given attempts. \n >>  Enjoy the challenge and have fun!\n");
            System.out.println("------------------------------------------------------------------------------\n");
            Random random = new Random();

            int n = 0;
            System.out.print("Enter 1 To Start The Game : ");
            n = sc.nextInt();
            System.out.println("\n------------------------------------------------------------------------------\n");
            while (n == 1) {

                int num = random.nextInt(1, 100);
                System.out.println("\nRandom number has been generated .....\n ");
                int guess = 0, i;

                for (i = 1; i <= 10; i++) {

                    System.out.println("Remaning chance are " + (11 - i));

                    System.out.print("Enter Your Guess Number " + i + " : ");
                    guess = sc.nextInt();
                    if (num == guess) {
                        System.out.println("You've guessed the correct number!\n");
                        System.out.println(
                                "------------------------------------------------------------------------------\n");
                        break;
                    } else if (guess > num) {
                        System.out.println("Your guess number is too high..You have to guess it again.\n");
                    } else {
                        System.out.println("Your guess number is too low..You have to guess it again.\n");
                    }
                    System.out.println(
                            "------------------------------------------------------------------------------\n");
                }

                if (guess != num) {
                    System.out.println("Your attempts are out of bond");
                } else {
                    System.out.println("Congratulations! Your Score is " + ((10 - i + 1) * 10));
                }
                System.out
                        .println("\n------------------------------------------------------------------------------\n");

                System.out.print("Do you want to continue? Enter 1 to continue,any other number to exit : ");
                n = sc.nextInt();
                System.out
                        .println("\n------------------------------------------------------------------------------\n");

            }
            System.out.println(
                    "Thank you for playing the Number Game! \nWe hope you enjoyed the challenge and had fun guessing the random number.");
            System.out.println("\n=============================================================================\n");
            sc.close();
            wel.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
