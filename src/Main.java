import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int choice; // used to control main loop
        Scanner reader = new Scanner(System.in);    // used for receiving input from the user.

        do {

            DisplayMenu();
            choice = reader.nextInt();

            switch (choice) {
                case 1:
                    OptionOne(reader);
                    break;
                case 2:
                    OptionTwo();
                    break;
                case 3:
                    OptionThree();
                    break;
                default:
                    System.out.println("Exiting...");
            }
        } while (choice != 4);

        reader.close();
    }

    public static void DisplayMenu() {
        System.out.println( "1. Zig Zag Weave \n" +
                            "2. Password Validation \n" +
                            "3. Substring Validation \n" +
                            "4. Exit");

        System.out.print("Please insert a number choice corresponding to the list: ");

    }

    public static void OptionOne(Scanner reader) {

        System.out.println("\n\nZig Zag Weave: ");
        System.out.print("Please write the first word to be used :");
        String stringOne = reader.nextLine();


        String stringTwo = reader.nextLine();

    }

    public static void OptionTwo() {

    }

    public static void OptionThree() {

    }
}