package algorithms.samsung;

import java.util.ArrayList;
import java.util.List;

public class GiftsFactory {

  class Gift {

    public Gift(int pNum) {
      this.pNum = pNum;
    }

    Gift prevGift;
    Gift nextGift;
    int pNum;
  }

  class LinkedBelt {
    Gift head;
    Gift tail;
    int cnt;
  }

  LinkedBelt[] belts = new LinkedBelt[];

  public void readInput() {

  }

  public void pushBoxFront(int pNum, int bNum) {
    int counter = 0;
    Gift gift = new Gift(pNum);
    if (belts[bNum-1].head == null)
      belts[bNum-1].head = gift;
    else {
      while(counter < belts.length) {
        if (!=null)  continue;
        belts[counter].nextGift = gift;
        d
      }
    }
    bBelt.cnt++;
    Gift oldHead = bBelt.head;
    bBelt.head = newHead;
    bBelt.head.back = oldHead;
  }

  public void pushBoxBack() {

  }

}
