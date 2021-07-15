package final_project;


public class TwoWayList {

  /** First node in list. */
  private Node first;

  public int t = 0;
  /** Current node position. */
  private Node current;

  /** Previous node position. */
  private Node last;

  /** Number of nodes. */
  private int length;

  /**
   * Return empty list with no current object.
   */
  public TwoWayList()
   {
    first    = null;
    current  = null;
    last     = null;
    length   = 0;
   } // constructor TwoWayList

  /**
   * Return true if this list is empty, false otherwise.
   */
  public boolean isEmpty() {
    return (length == 0);
  } // method isEmpty

  /**
   * Return true if no object is current, false otherwise.
   */
  public boolean atEnd() {
     return (current == last);
  } // method atEnd

  /**
   * Return this list's length.
   */
  public int length() {
    return length;
  } // method length

  /**
   * If this list is empty, do nothing.
   * Otherwise, make the first object current.
   */
  public void first()
  {
    current = first;
  } // method first

  public void last()
  {
    current = last;
  }

  public void next() {
    if ((current.next != null)){
//      System.out.println("before next() = " + current.data);
      current = current.next;
//      System.out.println("after next() = " + current.data);
}
    else
      {
      }
  }

  public void previous() {
     if( current != first){
       current = current.previous;
      }
      else
      {
       this.last();
      }
  }

  public Object access() {
    if (current != null)
      {
       return current.data;
      }
      return null;
  }

  public void replace(Object data) {
    current.data = data;
  }

  public void insert(Object data) {
    Node newNode = new Node(data);
     if ((current == null))
      {
          current = newNode;
          first = newNode;
          last = newNode;
      }
     else
      {
          if ((current == first))
           {
            current.next = newNode;
            newNode.previous = first;
            current = newNode;
            last = newNode;
           }
          else
           {
            newNode.next = current.next;
            if (current.next != null){current.next.previous = newNode;};
            current.next = newNode;
            newNode.previous = current;
            if (current == last){last = newNode;}
            current = newNode;
           }
      }
    length++;
  } // method insert

    public void insert(int x) {
    Node newNode = new Node(x);
     if ((current == null))
      {
          current = newNode;
          first = newNode;
          last = newNode;
      }
     else
      {
          if ((current == first))
           {
            current.next = newNode;
            newNode.previous = first;
            current = newNode;
            last = newNode;
           }
          else
           {
            newNode.next = current.next;
            if (current.next != null){current.next.previous = newNode;};
            current.next = newNode;
            newNode.previous = current;
            if (current == last){last = newNode;}
            current = newNode;
           }
      }
    length++;
  } // method insert
  public Object remove() {
    Object data = current.data;
    // Check for removal of first.
    if (current == first)
      {
       first = current.next;
      }
    else
      {
       current.previous.next = current.next;
       current.next.previous = current.previous;
      }
    current = current.next;
    length--;
    return data;
  } // method remove
} // class TwoWayList