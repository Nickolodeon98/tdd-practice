package algorithms.linkedlist;

import java.util.ArrayList;

public class LinkedListWithArrayList {
  static Ll linkedList = new Ll();
  static class Ll {
    ArrayList<Integer> list;
    int length;

    public Ll() {
      this.length = 0;
      this.list = new ArrayList<>();
    }
  }

  public static void insert(int data) {
    linkedList.list.add(data);
    linkedList.length++;
  }

  public static void delete(int pos) {
    if (pos == 0) return;

    if (pos > linkedList.length) return;

    for (int i = pos-1; i < linkedList.length-1; i++) {
      linkedList.list.set(i, linkedList.list.get(i+1));
    }
    linkedList.list.remove(linkedList.list.size()-1);
    linkedList.length--;
  }

  public static void find(int data) {
    for (int i = 0; i < linkedList.length; i++) {
      if (linkedList.list.get(i) == data) {
        System.out.println("position: " + (i+1));
        return;
      }
    }
    System.out.println("Not found");
  }

  public static void retrieve() {
    for (int i = 0; i < linkedList.length-1; i++) {
      System.out.print(linkedList.list.get(i)+"->");
    }
    System.out.println(linkedList.list.get(linkedList.length-1));
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

