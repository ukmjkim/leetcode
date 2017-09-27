import java.util.*;
public class LinkedListExample {
  public static void main(String args[]) {
    /* Linked List Declaration */
    LinkedList<String> linkedlist = new LinkedList<String>();

    /*add(String Element) is used for adding 
     * the elements to the linked list*/
    linkedlist.add("Item1");
    linkedlist.add("Item5");
    linkedlist.add("Item3");
    linkedlist.add("Item6");
    linkedlist.add("Item2");

    /*Display Linked List Content*/
    System.out.println("Linked List Content: " +linkedlist);

    /*Add First and Last Element*/
    linkedlist.addFirst("First Item");
    linkedlist.addLast("Last Item");
    System.out.println("LinkedList Content after addition: " +linkedlist);

    /*This is how to get and set Values*/
    Object firstvar = linkedlist.get(0);
    System.out.println("First element: " +firstvar);
    linkedlist.set(0, "Changed first item");
    Object firstvar2 = linkedlist.get(0);
    System.out.println("First element after update by set method: " +firstvar2);

    /*Remove first and last element*/
    linkedlist.removeFirst();
    linkedlist.removeLast();
    System.out.println("LinkedList after deletion of first and last element: " +linkedlist);

    /* Add to a Position and remove from a position*/
    linkedlist.add(0, "Newly added item");
    linkedlist.remove(2);
    System.out.println("Final Content: " +linkedlist); 

    linkedlist.offerFirst("New Element");

    Iterator i = linkedlist.iterator();
    while (i.hasNext()) {
      System.out.println(i.next());
    }

    Object firstElement = linkedlist.getFirst();
    System.out.println("First Element is: "+firstElement);

    Object lastElement = linkedlist.getLast();
    System.out.println("Last Element is: "+lastElement);

    int firstIndex = linkedlist.indexOf("New Element");
    System.out.println("First Occurrence: " + firstIndex);

    List sublist = linkedlist.subList(2,5);
    System.out.println("\nSub List elements:");
    System.out.println(sublist);

    System.out.println("\nDescending Iterator:");
    Iterator itr = linkedlist.descendingIterator();
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }
  }
}

