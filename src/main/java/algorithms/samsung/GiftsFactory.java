//package algorithms.samsung;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//import javax.sound.midi.MidiDevice;
//
//public class GiftsFactory {
//  int m = 0, n = 0, T = 0;
//
//  public void setM(int m) {
//    this.m = m;
//  }
//
//  public void setN(int n) {
//    this.n = n;
//  }
//
//  public void setT(int t) {
//    T = t;
//  }
//
//  class Gift {
//
//
//
//    public Gift(int pNum) {
//      this.pNum = pNum;
//    }
//
//    Gift prevGift;
//    Gift nextGift;
//    int pNum;
//    int bNum;
//
//    public Gift getPrevGift() {
//      return prevGift;
//    }
//
//    public Gift getNextGift() {
//      return nextGift;
//    }
//
//    public void setPrevGift(Gift prevGift) {
//      this.prevGift = prevGift;
//    }
//
//    public void setNextGift(Gift nextGift) {
//      this.nextGift = nextGift;
//    }
//
//    public int getPNum() {
//      return pNum;
//    }
//  }
//
//  Gift[] beltHeads = new Gift[10];
//
//  public String[] readCommand() {
//    Scanner sc = new Scanner(System.in);
//
//    String[] input = sc.nextLine().split(" ");
//
//    return input;
//  }
//
//  public void process() {
//    int cnt = 0;
//    String[] input = readCommand();
//    String command = input[0];
//    int src = Integer.parseInt(input[1]);
//    int dest = Integer.parseInt(input[2]);
//
//    while (cnt != T) {
//      cnt++;
//
//      if (command.equals("100")) {
//        code100(input);
//      } else if (command.equals("200")) {
//        code200(src, dest);
//      } else if (command.equals("300")) {
//        code300(src, dest);
//      } else if (command.equals("400")) {
//        code400(src, dest);
//      } else if (command.equals("500")) {
//        code500(src, dest);
//      } else if (command.equals("600")) {
//        code600(src, dest);
//      }
//    }
//  }
//
//  public int countGifts(Gift headGift) {
//    int count = 0;
//    while (headGift.getNextGift() != null) {
//      headGift = headGift.getNextGift();
//    }
//
//    while (headGift.getPrevGift() != null) {
//      count++;
//      headGift = headGift.getPrevGift();
//    }
//
//    return count;
//  }
//  public void retrieveBelt(Gift headGift) {
//    while (headGift != null) {
//      System.out.print(headGift + "-> ");
//      headGift = headGift.getNextGift();
//    }
//  }
//
//  public Gift pushBoxFront(Gift headGift, Gift newBox) {
//    while (headGift.getNextGift() != null) {
//      headGift = headGift.getNextGift();
//    }
//    headGift.setNextGift(newBox);
//
//    return headGift;
//  }
//
//  public Gift pushBoxBack(Gift headGift, Gift newBox) {
//    while (headGift.getPrevGift() != null) {
//      headGift = headGift.getPrevGift();
//    }
//    headGift.setPrevGift(newBox);
//
//    return headGift;
//  }
//
//  public Gift identifyABelt(int pNum) {
//    for (Gift gift : beltHeads) {
//      if (gift.getPNum() == pNum)
//        return gift;
//    }
//    return null;
//  }
//
//  public void code100(String[] prompts) {
//    setN(Integer.parseInt(prompts[1]));
//    setM(Integer.parseInt(prompts[2]));
//
//    for (int order = 3; order < prompts.length; order++) {
//      beltHeads[Integer.parseInt(prompts[order])-1] = new Gift(order - 2);
//    }
//  }
//
//  public void code200(int src, int dest) {
//    if (beltHeads[src] == null) return;
//
//    pushBoxFront(beltHeads[dest], beltHeads[src]);
//
//    beltHeads[src] = null;
//
//    System.out.println(countGifts(identifyABelt(dest)));
//  }
//
//  public void code300(int src, int dest) {
//    System.out.println(countGifts(identifyABelt(dest)));
//
//    Gift firstSrc = identifyABelt(src);
//    Gift firstDest = identifyABelt(dest);
//
//    beltHeads[dest].setNextGift(firstSrc);
//    pushBoxFront(beltHeads[dest], firstSrc);
//    beltHeads[src].setNextGift(firstDest);
//    pushBoxFront(beltHeads[src], firstDest);
//  }
//
//  public void code400(int src, int dest) {
//    double a = Math.floor(countGifts(identifyABelt(src))/ 2);
//
//    int divisionCnt = 0;
//    while (a != divisionCnt) {
//      divisionCnt++;
//
//      pushBoxFront(identifyABelt(src), identifyABelt(dest));
//    }
//    System.out.println(countGifts(identifyABelt(dest)));
//
//  }
//
//
//
//  public void code500(int pNum) {
//
//
//    Gift targetGift = identifyABelt(pNum);
//    int prev = targetGift.getPrevGift() == null ? -1 : targetGift.getPrevGift().getPNum();
//    int next = targetGift.getNextGift() == null ? -1 : targetGift.getNextGift().getPNum();
//    int result = prev + 2 * next;
//
//    System.out.println(result);
//  }
//
//  public Gift findEnd(Gift headGift) {
//    while (headGift.getPrevGift() != null) {
//      headGift = headGift.getPrevGift();
//    }
//    return headGift;
//  }
//
//  public void code600(int bNum) {
//    int a = beltHeads[bNum-1] == null ? -1 : beltHeads[bNum-1].getPNum();
//    Gift tailGift = findEnd(beltHeads[bNum-1]);
//    int b = tailGift == null ? -1 : tailGift.getPNum();
//
//    int c = countGifts(beltHeads[bNum-1]);
//
//    int result = a + 2 * b + 3 * c;
//
//    System.out.println(result);
//  }
//}
