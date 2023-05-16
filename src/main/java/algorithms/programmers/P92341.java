package algorithms.programmers;

import java.util.*;

public class P92341 {

  class Record {

    String carNum;
    String in;
    String out;
    int spent;

    Record(String carNum, String in) {
      this.carNum = carNum;
      this.in = in;
      this.out = "23:59";
    }

    void setIn(String in) {
      this.in = in;
    }

    String getCarNum() {
      return this.carNum;
    }

    void setOut(String out) {
      this.out = out;
    }

    String getOut() {
      return this.out;
    }

    int getSpent() {
      this.spent = computeTimeGap(in, out);
      return this.spent;
    }
  }

  public int computeTimeGap(String time1, String time2) {
    String[] hourAndMins1 = time1.split(":");
    String[] hourAndMins2 = time2.split(":");
    int hourGap = Integer.parseInt(hourAndMins2[0]) - Integer.parseInt(hourAndMins1[0]);
    int minGap = Integer.parseInt(hourAndMins2[1]) - Integer.parseInt(hourAndMins1[1]);

    return (hourGap * 60) + minGap;
  }

  public int[] calcFee(int[] fees, String[] records) {
    HashMap<String, Record> cars = new HashMap<>();
    HashMap<String, Integer> feeInfo = new HashMap<>();

    int totalSpent = 0;
    for (String record : records) {
      String[] info = record.split(" ");
      String timeStamped = info[0];
      String carNum = info[1];
      String type = info[2];

      if (type.equals("OUT")) {
        if (!cars.isEmpty()) {
          cars.get(carNum).setOut(timeStamped);
          if (!feeInfo.isEmpty() && feeInfo.get(carNum) != null) {
            feeInfo.put(carNum, feeInfo.get(carNum) + cars.get(carNum).getSpent());
          } else {
            feeInfo.put(carNum, cars.get(carNum).getSpent());
          }
        }
        continue;
      }

      if (cars.isEmpty()) {
        cars.put(carNum, new Record(carNum, timeStamped));
      } else {
        if (cars.get(record) == null) {
          cars.put(carNum, new Record(carNum, timeStamped));
          continue;
        }
        cars.get(carNum).setIn(timeStamped);
        cars.put(carNum, cars.get(carNum));
        cars.get(carNum).setOut("23:59");
        cars.put(carNum, cars.get(carNum));
      }
    }

    for (Map.Entry e : cars.entrySet()) {
      Record r = (Record) e.getValue();
      String carInfo = r.getCarNum();
      if (r.getOut().equals("23:59")) {
        if (!feeInfo.isEmpty()) {
          feeInfo.put(carInfo, feeInfo.get(carInfo) + cars.get(carInfo).getSpent());
        } else {
          feeInfo.put(carInfo, cars.get(carInfo).getSpent());
        }
      }
    }
    List<Map.Entry<String, Integer>> fares = new ArrayList<>(feeInfo.entrySet());
    Collections.sort(fares, (o1, o2) -> {
      return Integer.parseInt(o1.getKey()) - Integer.parseInt(o2.getKey());
    });

    int[] total = new int[cars.size()];
    int cnt = 0;
    for (Map.Entry timeInfo : fares) {
      int spentTime = (int) timeInfo.getValue();
      if (fees[0] < spentTime) {
        total[cnt] =
            fees[1] + (fees[3] * (int) Math.ceil((spentTime - fees[0]) / (double) fees[2]));
      } else {
        total[cnt] = fees[1];
      }
      cnt++;
    }

    return total;
  }

  public int[] solution(int[] fees, String[] records) {
    int[] answer = {};

    answer = calcFee(fees, records);

    return answer;
  }

  public static void main(String[] args) {
    P92341 test = new P92341();
    int[] answer = test.solution(new int[]{180, 5000, 10, 600},
        new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});

    for (int i : answer) {
      System.out.println(i);

    }
  }
}


