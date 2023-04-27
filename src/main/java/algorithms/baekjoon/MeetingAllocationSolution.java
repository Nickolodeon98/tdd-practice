package algorithms.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MeetingAllocationSolution {
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

    public List<Meeting> sortMeeting(List<Meeting> meetings) {
      return divide(meetings);
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
        if (single.getStart() < meetings.get(pivotIdx).getStart()) {
          left.add(single);
          continue;
        }
        if (single.getStart() > meetings.get(pivotIdx).getStart()) {
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

    public List<Meeting> promptUser() {
      Scanner sc = new Scanner(System.in);

      int N = Integer.parseInt(sc.nextLine());

      List<Meeting> meetings = new ArrayList<>();

      for (int i = 0; i < N; i++) {
        String[] temporalInfo = sc.nextLine().split(" ");
        Meeting meeting = new Meeting(Integer.parseInt(temporalInfo[0]), Integer.parseInt(temporalInfo[1]));
        meetings.add(meeting);
      }

      return sortMeeting(meetings);
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
    }

    public static void main(String[] args) {
      MeetingAllocationSolution test = new MeetingAllocationSolution();
      System.out.println(test.solution());
    }


}
