package algorithms.programmers;

import java.util.*;

public class P92341_2 {

  public int[] calcFee(int[] fees, String[] records) {
    HashMap<String, String> cars = new HashMap<>();
    HashMap<String, Integer> feeInfo = new HashMap<>();

    for (String record : records) {
      feeInfo.put(record.split(" ")[1], 0);
    }

    int totalSpent = 0;
    for (String record : records) {
      String[] info = record.split(" ");
      String timeStamped = info[0];
      String carNum = info[1];
      String type = info[2];

      if (cars.containsKey(carNum)) { // 출차일 때
        String[] inTime = cars.remove(carNum).split(":");
        String[] outTime = timeStamped.split(":");

        int hourGap = Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]);
        int minGap = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);

        feeInfo.replace(carNum, feeInfo.get(carNum) + (60 * hourGap) + minGap);

      } else { //입차일때
        cars.put(carNum, timeStamped);
      }

    }
    if (!cars.isEmpty()) {
      for (Map.Entry time : cars.entrySet()) {
        String in = (String) time.getValue();
        String[] temporal = in.split(":");
        int hour = 23 - Integer.parseInt(temporal[0]);
        int min = 59 - Integer.parseInt(temporal[1]);

        String carInfo = (String) time.getKey();
        feeInfo.replace(carInfo, feeInfo.get(carInfo) + (hour * 60) + min);
      }
    }

    List<Map.Entry<String, Integer>> fares = new ArrayList<>(feeInfo.entrySet());
    Collections.sort(fares, (o1, o2) -> {
      return Integer.parseInt(o1.getKey()) - Integer.parseInt(o2.getKey());
    });

    int[] total = new int[fares.size()];
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
    P92341_2 test = new P92341_2();
    int[] result = test.solution(new int[]{180, 5000, 10, 600},
        new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});

    for (int i : result) {
      System.out.println(i);
    }
  }
}

