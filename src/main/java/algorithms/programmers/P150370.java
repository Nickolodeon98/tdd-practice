package algorithms.programmers;

import java.util.*;

public class P150370 {

  static class Date {

    int year;
    int month;
    int day;

    Date(String year, String month, String day) {
      this.year = Integer.parseInt(year);
      this.month = Integer.parseInt(month);
      this.day = Integer.parseInt(day);
    }

    void setMonth(int added) {
      this.month += added;
      while (this.month > 12) {
        year += 1;
        month -= 12;
      }
    }

    int getMonth() {
      return this.month;
    }

    int getYear() {
      return this.year;
    }

    int getDay() {
      return this.day;
    }
  }

  public List<Integer> solution(String today, String[] terms, String[] privacies) {
    List<Integer> answer = new ArrayList<>();

    String[] data = today.split("\\.");
    Date todayInfo = new Date(data[0], data[1], data[2]);
    Map<String, Integer> termsInfo = new HashMap<>();

    for (String info : terms) {
      String[] pair = info.split(" ");
      termsInfo.put(pair[0], Integer.parseInt(pair[1]));
    }

    for (int i = 0; i < privacies.length; i++) {
      String[] expiry = privacies[i].split(" ");
      String[] datePart = expiry[0].split("\\.");

      Date dayInfo = new Date(datePart[0], datePart[1], datePart[2]);

      dayInfo.setMonth(termsInfo.get(expiry[1]));

      if (isExpired(todayInfo, dayInfo)) {
        answer.add(i + 1);
      }
    }

    return answer;
  }

  public boolean isExpired(Date target, Date toCompare) {
    if (target.getYear() > toCompare.getYear()) {
      return true;
    } else {
      if (target.getYear() == toCompare.getYear()) {
        if (target.getMonth() > toCompare.getMonth()) {
          return true;
        } else {
          if (target.getMonth() == toCompare.getMonth()) {
            if (target.getDay() >= toCompare.getDay()) {
              return true;
            } else {
              return false;
            }
          } else {
            return false;
          }
        }
      } else {
        return false;
      }
    }
  }

}
