public class Utils {
    // This is just a class for utility functions to clean up the main file.

    // there's probably gonna be a lot of this....
    public static void StringToLinkList(String wordString, LinkList wordLink) {
        for (int i = wordString.length()-1; i >= 0 ; i--) {
            wordLink.InsertFirst(i, wordString.charAt(i));
        }
    }

    // Don't know if int type casting the char to compare ascii values is more/less/equal in computation.
    public static boolean IsDigit(char letter) {
        return (letter >= '0' && letter <= '9');
    }

    public static boolean IsSymbol(char letter) {
        return (
            (letter >= '!' && letter <= '/') ||
            (letter >= ':' && letter <= '@') ||
            (letter >= '[' && letter <= '`') ||
            (letter >= '{' && letter <= '~')
        );

    }




}
