public class HW3 {

  public static class dList {

    private Node Head;
    private Node Tail;

    private class Node {

      private int value;
      private Node next;
      private Node prev;
    }

    void revert() {
      Node node = Head;
      Node tmp = Head;
      Head = Tail;
      Tail = tmp;
   
      while (node != null) {
        tmp = node.next;
        node.next = node.prev;
        node.prev = tmp;
        node = tmp;
      }
    }

    void pushFront(int value) {
      Node node = new Node();
      node.value = value;
      if (Head != null) {
        Head.prev = node;
        node.next = Head;
      } else {
        Tail = node;
      }

      Head = node;
    }

    Integer popFront() {
      if (Head != null) {
        Integer value = Head.value;
        if (Head.next != null) {
          Head = Head.next;
          Head.prev = null;
        } else {
          Head = null;
          Tail = null;
        }
        return value;
      }
      return null;
    }

    void print() {
      Node current = Head;
      while (current != null) {
        System.out.println(current.value);
        current = current.next;
      }
    }

    void pushBack(int value) {
      Node node = new Node();
      node.value = value;

      if (Tail != null) {
        Tail.next = node;
        node.prev = Tail;
      } else {
        Head = node;
      }

      Tail = node;
    }

    Node find(int value) {
      Node current = Head;
      while (current != null) {
        if (current.value == value) {
          return current;
        }
        current = current.next;
      }
      return null;
    }

    Node revFind(int value) {
      Node current = Tail;
      while (current != null) {
        if (current.value == value) {
          return current;
        }
        current = current.prev;
      }
      return null;
    }
  }

  public static void main(String[] args) {
    dList list = new dList();

    list.pushBack(1);
    list.pushBack(2);
    list.pushBack(3);
    list.print();

    list.revert();

    System.out.println("----");
    list.print();
  }
}
