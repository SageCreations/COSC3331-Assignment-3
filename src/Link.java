public class Link {
    public int iData;
    public char charTypeData;
    public Link next;

    public Link(int id, char cd) // constructor
    {
        iData = id; // initialize data
        charTypeData = cd;
        // (‘next’ is automatically set to null)
    }

    public void DisplayLink() {
        System.out.print("{" + iData + ", " + charTypeData + "} ");
    }
}
