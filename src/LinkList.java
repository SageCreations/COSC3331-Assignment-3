public class LinkList {
    public Link first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void InsertFirst(int id, char cd) {
        Link newLink = new Link(id, cd);
        newLink.next = first;
        first = newLink;
    }

    public Link DeleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public Link Find(int key) {
        Link current = first;
        while (current.iData != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Link Delete(int key) {
        Link current = first;
        Link previous = first;

        while (current.iData != key) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }

        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }

        return current;
    }


    public void DisplayList() {
        System.out.print("List (first-->Last): ");
        Link current = first;
        while (current != null) {
            current.DisplayLink();
            current = current.next;
        }
        System.out.println("");
    }

}
