package algorithms.baekjoon;

import algorithms.baekjoon.B1931.Meeting;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MeetingAllocation {

  class Meeting {

    int start;
    int end;

    Meeting(int start, int end) {
      this.start = start;
      this.end = end;
    }

    public int getStart() {
      return start;
    }

    public int getEnd() {
      return end;
    }
  }

  public void sortMeeting() {
    Scanner sc = new Scanner(System.in);

    int N = Integer.parseInt(sc.nextLine());
    List<Meeting> meetings = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      String[] meetingInfo = sc.nextLine().split(" ");
      Meeting m = new Meeting(Integer.parseInt(meetingInfo[0]), Integer.parseInt(meetingInfo[1]));
      meetings.add(m);
    }

    for (Meeting meeting : meetings) {
      System.out.println(meeting.getStart() + ", " + meeting.getEnd());
    }

    List<Meeting> sortedMeetings = divide(meetings);

    for (Meeting meeting : sortedMeetings) {
      System.out.println(meeting.getStart() + ", " + meeting.getEnd());
    }
  }

  public boolean isAllSame(List<Meeting> meetings) {
    int standard = meetings.get(0).getEnd();
    for (Meeting m : meetings) {
      if (m.getEnd() != standard)
        return false;
    }
    return true;
  }

  public List<Meeting> divide(List<Meeting> meetings) {
    if (meetings.size() <= 1 || isAllSame(meetings))
      return meetings;

    int pivotIdx = meetings.size() / 2;
    int pivot = meetings.get(pivotIdx).getEnd();

    List<Meeting> left = new ArrayList<>();
    List<Meeting> center = new ArrayList<>();
    List<Meeting> right = new ArrayList<>();

    for (Meeting single : meetings) {
      if (single.getEnd() < pivot) {
        left.add(single);
        continue;
      }
      if (single.getEnd() > pivot) {
        right.add(single);
        continue;
      }
      center.add(single);
    }

    return merge(left, center, right);
  }

  public List<Meeting> merge(List<Meeting> left, List<Meeting> center, List<Meeting> right) {
    List<Meeting> processed = divide(left);
    processed.addAll(center);
    processed.addAll(divide(right));
    return processed;
  }

  public static void main(String[] args) {
    MeetingAllocation test = new MeetingAllocation();

    test.sortMeeting();
  }
}