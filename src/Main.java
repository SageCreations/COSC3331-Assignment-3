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
                    OptionTwo(reader);
                    break;
                case 3:
                    OptionThree(reader);
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
        Utils.StringToLinkList(stringOne, wordOne);

        // Get second word from user.
        System.out.print("Please type the second word to be used: ");
        String stringTwo = reader.nextLine();
        // another O(n) ;_;
        Utils.StringToLinkList(stringTwo, wordTwo);

        // do the zig zag
        Link w1 = wordOne.first; // assign walker one to wordOne's first node
        Link w2 = wordTwo.first; // assign walker two to wordTwo's first node
        while (w1.next != null && w2.next != null) {
            Link temp = w1.next;    // create a temp link assigned with walker one next
            w1.next = w2.next;      // now change walker one's link to the next letter in the second word.
            w1 = temp;              // move walker one foreword through word one
            w2 = w2.next;           // move walker two foreword through word two
            temp = w2.next;         // reassign temp to the new walker two's next
            w2.next = w1.next;      // assign walker two's next to walker one's next (completes the first zig-zag pass)
            w1 = w2.next;           // move walker one foreword through word one (possible with the previous step)
            w2 = temp;              // move walker two foreword through word two (essentially back to init state ready to do the same for the next 3 links on repeat)

            // if word one is longer than word two, the while loop will end but
            // the rest of word one will still be linked. This will cut off the
            // rest and leave it in the void.
            if (null == w2.next) {
                w1.next = null;
            }
        }
        wordOne.DisplayList();
    }

    public static void OptionTwo(Scanner reader) {
        System.out.print("Please type a password: ");
        String password = reader.nextLine();
        LinkList passlink = new LinkList();
        Utils.StringToLinkList(password, passlink);

        // • Passwords can ONLY have letters (assumed in uppercase) and digits.
        // • Passwords cannot start or end with a digit.
        // • If there are digits in the password, they must have vowels on both sides.
        // • Passwords cannot have double letters: no double consonants, no double vowels.

        /*
         * Double letter violation
         * Start with digit violation
         * End with digit violation
         * Invalid Symbol violation
         * Vowel-Digit-Vowel violation
         */

        // are we allowed to use enums?
        boolean doubleLetter = false;
        boolean digitFirst = false;
        boolean digitLast = false;
        boolean invalidSymbol = false;
        boolean vowelDv = false;

        //digitFirst check
        if (Utils.IsDigit(passlink.first.charTypeData)) {
            digitFirst = true;
        }

        Link walker = passlink.first;
        while (walker.next != null) {
            //double letter check
            if (walker.charTypeData == walker.next.charTypeData) {
                doubleLetter = true;
            }

            if (Utils.IsSymbol(walker.charTypeData)) {
                invalidSymbol = true;
            }


			//TODO: Vowel-digit-vowel check.
			if (Utils.IsDigit(walker.next.charTypeData)) {
				if(Utils.IsVowel(walker.charTypeData)) {
					if (null != walker.next.next && Utils.IsVowel(walker.next.next)) {
					
					}
				}
			}




            walker = walker.next; // iterate through the linklist

            if (null == walker.next && Utils.IsDigit(walker.charTypeData)) {
                digitLast = true;
            }
        }

        if (doubleLetter) {
            System.out.println("Double letter violation");
        }
        if (digitFirst) {
            System.out.println("Start with digit violation");
        }
        if (digitLast) {
            System.out.println("End with digit violation");
        }
        if (invalidSymbol) {
            System.out.println("Invalid Symbol violation");
        }
        if (vowelDv) {

        }
    }

    public static void OptionThree(Scanner reader) {

    }


}
