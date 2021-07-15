package final_project;

/**
 * Represent nodes in linked list.
 */
class Node {

  /** Handle to list data item. */
  Object data;
  int x;


  Node previous;
  /** Link to next node. */
  Node next;

  /**
   *  Return empty list node containing object data.
   */
  Node(Object data) {
    this.data = data;
    this.next = null;
    this.previous = null;
  } // constructor Node

  Node(int x)
  { this.x = x;
    this.next = null;
    this.previous = null;
  }

} // class Node