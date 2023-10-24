import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int choice; // used to control main loop
        Scanner reader = new Scanner(System.in);    // used for receiving input from the user.

        do {

            DisplayMenu();
            choice = reader.nextInt();
            reader.nextLine();

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
        // instantiation of the link lists needed for this option.
        LinkList wordOne = new LinkList();
        LinkList wordTwo = new LinkList();

        // clarity for option chosen
        System.out.println("\n\nZig Zag Weave: ");

        //get first word from user.
        System.out.print("Please type the first word to be used: ");
        String stringOne = reader.nextLine();
        // O(n) already ;_;
        StringToLinkList(stringOne, wordOne);


        // Get second word from user.
        System.out.print("Please type the second word to be used: ");
        String stringTwo = reader.nextLine();
        // another O(n) ;_;
        StringToLinkList(stringTwo, wordTwo);

        wordOne.DisplayList();
        wordTwo.DisplayList();


        // do the zig zag
        //start the ptr at word ones header link.
        Link walkerOne = wordOne.first;
        Link walkerTwo = wordTwo.first.next;


        while (walkerOne != null || walkerTwo != null) {
            if (walkerOne.next == null || walkerTwo.next == null) {
                walkerOne.next = null;
                break;
            }

            Link temp1 = walkerOne.next;
            Link temp2 = walkerTwo.next;


            walkerOne.next = walkerTwo;
            walkerTwo.next = temp1.next;

            walkerOne = (temp1.next != null) ? temp1.next : null;
            walkerTwo = (temp2.next != null) ? temp2.next : null;

            wordOne.DisplayList();
        }

        wordOne.DisplayList();
        //wordTwo.DisplayList();


    }

    public static void OptionTwo() {

    }

    public static void OptionThree() {

    }

    // there's probably gonna be a lot of this....
    public static void StringToLinkList(String wordString, LinkList wordLink) {
        for (int i = wordString.length()-1; i >= 0 ; i--) {
            wordLink.InsertFirst(i, wordString.charAt(i));
        }
    }
}