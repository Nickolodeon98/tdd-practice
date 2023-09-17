package algorithms.linkedlist;

public class LinkedListWithArray {
  static Ll linkedList = new Ll();
  static class Ll {
    int[] list;
    int length;

    public Ll() {
      this.length = 0;
      this.list = new int[10];
    }
  }

  public static void insert(int data) {
      linkedList.list[linkedList.length] = data;
      linkedList.length++;
  }

  public static void delete(int pos) {
    if (pos == 0) return;

    if (pos > linkedList.length) return;

    for (int i = pos-1; i < linkedList.length; i++) {
      linkedList.list[i] = linkedList.list[i+1];
    }
    linkedList.length--;
  }

  public static void find(int data) {
    for (int i = 0; i < linkedList.length; i++) {
      if (linkedList.list[i] == data) {
        System.out.println("position: " + (i+1));
        return;
      }
    }
    System.out.println("Not found");
  }
  
  public static void retrieve() {
    for (int i = 0; i < linkedList.length-1; i++) {
      System.out.print(linkedList.list[i]+"->");
    }
    System.out.println(linkedList.list[linkedList.length-1]);
  }

  public static void main(String[] args) {
    insert(3);
    insert(4);
    insert(5);
    retrieve();
    find(5);
    delete(2);
    retrieve();
    find(5);
  }
}
