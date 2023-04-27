package algorithms.baekjoon;

import algorithms.baekjoon.MeetingAllocation.Meeting;
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
      this.start = 2147483647;
      this.end = 2147483647;
      this.gap = 2147483647;
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

  public List<Meeting> sortMeeting(List<Meeting> meetings, Pivoting pivoting) {
    for (Meeting meeting : meetings) {
      System.out.println(meeting.getStart() + ", " + meeting.getEnd());
    }

    List<Meeting> sortedMeetings = divide(meetings, pivoting);

    for (Meeting meeting : sortedMeetings) {
      System.out.println(meeting.getStart() + ", " + meeting.getEnd());
    }

    return sortedMeetings;
  }

  public boolean isAllSame(List<Meeting> meetings, Pivoting pivoting) {
    int standard = pivoting.pivot(meetings.get(0));
    for (Meeting m : meetings) {
      if (pivoting.pivot(m) != standard)
        return false;
    }
    return true;
  }

  interface Pivoting {
    int pivot(Meeting meeting);
  }

  public List<Meeting> divide(List<Meeting> meetings, Pivoting pivoting) {
    if (meetings.size() <= 1 || isAllSame(meetings, pivoting))
      return meetings;

    int pivotIdx = meetings.size() / 2;
    int pivot = pivoting.pivot(meetings.get(pivotIdx));

    List<Meeting> left = new ArrayList<>();
    List<Meeting> center = new ArrayList<>();
    List<Meeting> right = new ArrayList<>();

    for (Meeting single : meetings) {
      if (pivoting.pivot(single) < pivot) {
        left.add(single);
        continue;
      }
      if (pivoting.pivot(single) > pivot) {
        right.add(single);
        continue;
      }
      center.add(single);
    }

    return merge(left, center, right, pivoting);
  }

  public List<Meeting> merge(List<Meeting> left, List<Meeting> center, List<Meeting> right, Pivoting pivoting) {
    List<Meeting> processed = divide(left, pivoting);
    processed.addAll(center);
    processed.addAll(divide(right, pivoting));
    return processed;
  }
//  정렬 끝난 후:




  public int computeGap(List<Meeting> meetings, Meeting curStart) {
    int minGap = 2147483647;

    int minI = -1;

    for (int i = 0; i < meetings.size(); i++) {
      if (meetings.get(i).getStart() - curStart.getEnd() >= 0) {
        if (minGap > meetings.get(i).getEnd() - curStart.getEnd()) {
          minGap = meetings.get(i).getEnd() - curStart.getEnd();
          minI = i;
        }
        if (minGap == meetings.get(i).getEnd() - curStart.getEnd()) {
          if (meetings.get(i).getStart() < meetings.get(minI).getStart()) {
            minI = i;
          }
        }
      }
    }
    return minI;
  }


  public List<Meeting> promptUser() {
    Scanner sc = new Scanner(System.in);

    int N = Integer.parseInt(sc.nextLine());

    List<Meeting> meetings = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      String[] temporalInfo = sc.nextLine().split(" ");
      Meeting meeting = new Meeting(Integer.parseInt(temporalInfo[0]), Integer.parseInt(temporalInfo[1]));
      meetings.add(meeting);
    }
    List<Meeting> sortedMeetings = sortMeeting(meetings, Meeting::getStart);

    sortedMeetings = sortMeeting(sortedMeetings, Meeting::getEnd);

    return sortedMeetings;
  }

  public int solution() {
    int counter = 1;

    List<Meeting> meetings = promptUser();

    int curStart = meetings.get(0).getStart();
    int curEnd = meetings.get(0).getEnd();

    for (int j = 1; j < meetings.size(); j++) {
      if (meetings.get(j).getStart() >= curEnd) {
        curEnd = meetings.get(j).getEnd();
        counter++;
      }

    }

    return counter;


//    Meeting latestMeeting = new Meeting();
//
//    for (Meeting m : meetings) {
//      if (m.getEnd() < latestMeeting.getEnd()) {
//        latestMeeting = m;
//        continue;
//      }
//      if (m.getEnd() == latestMeeting.getEnd()) {
//        if (latestMeeting.getGap() > m.getGap()) {
//          latestMeeting = m;
//        }
//      }
//    }
//    meetings.remove(latestMeeting);
//    int idx = 0;
//
//    while (true) {
//      System.out.println(latestMeeting.getStart() + ", " + latestMeeting.getEnd());
//      idx = computeGap(meetings, latestMeeting);
//      if (idx == -1) break;
//      latestMeeting = meetings.get(idx);
//      counter++;
//      meetings.remove(idx);
//    }

//    return counter;
  }

  public static void main(String[] args) {
    B1931 test = new B1931();
    System.out.println(test.solution());
  }
}
