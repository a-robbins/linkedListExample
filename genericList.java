import java.util.Iterator;

public class GenericList <iType> implements Iterable<iType>
{
    private class Node
    {
        iType val; // reference -- same as pointer
        Node next;
        Node prev;

        public Node(iType v) //constructor
        {
            val = v;
            next = null;
            prev = null;
        }
    }

    private Node head; // instance variable
    private Node tail;
    private int curr_size;

    public  GenericList()
    {
        head = null;
        tail = null;
    }

    public void print() {
        Node walker = head;

        StdOut.print("head ---> ");
        print(head); // calling our recursive function
  /*      while (walker != null)
        {

            StdOut.printf("%d ---> ", walker.val);
            walker = walker.next;
        }

   */
        StdOut.print("null\n");
    }

    private void print(Node n) // overloaded
    {
        if(n == null)
        {
            return;
        }
        // recursive print function
        StdOut.print(n.val);
        StdOut.print(" ---> ");
        print(n.next);

    }

    public int getSize()

    {
        return curr_size;
    }
    public void insertFront(iType val) {
        Node n = new Node(val);

        if (head != null) {
            n.next = head;
        }
        else
        {
            tail = n; // head an tail point to same if list empty
        }
        head = n;

    }

    public void insertBack(iType val)
    {
        Node n = new Node(val);

        if(head == null) // list only has one element
        {
            head = n;
            tail = head;
        }
        else
        {
            tail.next = n;
            tail = n;
        }
    }

    public boolean inList(iType val)
    {
        Node walker = head;

        while(walker != null)
        {
            if(walker.val == val)
            {
                return true;
            }
            else
            {
                walker = walker.next;
            }
        }

        return false;
    }

    public Iterator<iType> iterator() // iterator = interface to provide access to private items but not allow modification
    {
        return new GenericListIterator();
    }


    private class GenericListIterator implements Iterator<iType>
    {
        private Node curr = head;

        public boolean hasNext()
        {
            return curr != null;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public iType next()
        {
            iType val = curr.val;
            curr = curr.next;
            return val;
        }
    }


    public static void main(String[] args)
    {
        GenericList<Integer> ll = new GenericList<Integer>(); // Integer, String, etc = wrapper

   /*     while (StdIn.isEmpty() == false)
        {
            ll.insertFront(StdIn.readString());
            ll.print();

            if (ll.inList("20")) {
                StdOut.print("found it!\n");
            }
        }
    */
        for (int i = 0; i < 25; i++)
        {
            ll.insertFront(i);
        }

        for (Integer i : ll) // Syntatic Sugar for (Iterator i = ll.iterator(); i.hasNext() )
        {
            StdOut.println(i);
        }
    }
}
