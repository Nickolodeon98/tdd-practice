package algorithms.baekjoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class B1931 {

  class Meeting {
    int gap;
    int start;
    int end;

    Meeting(int start, int end) {
      this.start = start;
      this.end = end;
      this.gap = end - start;
    }

    Meeting() {
      this.start = 0;
      this.end = 0;
      this.gap = 0;
    }

    int getGap() {
      return gap;
    }

    int getStart() {
      return start;
    }

    int getEnd() {
      return end;
    }
  }


  public int computeGap(Meeting[] meetings, Meeting curStart, List<Meeting> gatherings) {
    int minGap = 9999;

    int minI = -1;

    for (int i = 0; i < meetings.length; i++) {
      if (gatherings.contains(meetings[i])) continue;

      if (curStart == meetings[i]) continue;

      if (curStart.getStart() - meetings[i].getEnd() >= 0) {
        if (minGap > curStart.getStart() - meetings[i].getStart()) {
          minGap = curStart.getStart() - meetings[i].getEnd();
          minI = i;
          continue;
        }
        if (minGap == curStart.getStart() - meetings[i].getStart()) {
          if (meetings[minI].getGap() > meetings[i].getGap()) {

            minI = i;
          }
        }
      }
    }

    return minI;
  }


  public Meeting[] promptUser() {
    Scanner sc = new Scanner(System.in);

    int N = Integer.parseInt(sc.nextLine());

    Meeting[] meetings = new Meeting[N];

    for (int i = 0; i < N; i++) {
      String[] temporalInfo = sc.nextLine().split(" ");
      Meeting meeting = new Meeting(Integer.parseInt(temporalInfo[0]), Integer.parseInt(temporalInfo[1]));
      meetings[i] = meeting;
    }

    return meetings;
  }

  public int solution() {
    int currentMeeting = 0;
    int counter = 0;

    List<Meeting> results = new ArrayList<>();

    Meeting[] meetings = promptUser();

    Meeting latestMeeting = new Meeting();

    for (Meeting m : meetings) {
      currentMeeting = m.getEnd();
      if (currentMeeting > latestMeeting.getEnd())
        latestMeeting = m;
    }
    results.add(latestMeeting);
    int idx = 0;

    while (true) {
      idx = computeGap(meetings, latestMeeting, results);
      if (idx == -1) break;
      results.add(meetings[idx]);
      latestMeeting = meetings[idx];
    }

    counter = results.size();
    for (Meeting m : results) {
      System.out.println(m.getStart() + ", " + m.getEnd());
    }
    return counter;
  }

  public static void main(String[] args) {
    B1931 test = new B1931();
    System.out.println(test.solution());
  }
}
