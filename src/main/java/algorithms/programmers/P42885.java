package algorithms.programmers;

import java.util.Arrays;

public class P42885 {

  public int optimalNum(int[] people, int limit, int population) {

    int minSum = 10000;
    int minP1 = -1, minP2 = -1;
    int countBoat = 0;
    int maxPerson = 0;
    int maxL = 0;

    int currentSum = 0;
    Arrays.sort(people);

    for (int k = 0; k < people.length; k++) {
      if (population == 1) {
        countBoat++;
        population--;
        break;
      }
      for (int l = 0; l < people.length; l++) {
        //             [70, 50, 80, 50]
        if (k == minP1 || k == minP2 || l == minP1 || l == minP2 || k == maxL || l == maxL
            || k == l) {
          continue;
        }

        if (minSum != 10000) {

          minSum = getOptimal(minSum, people[k] + people[l], limit);
          minP1 = k;
          minP2 = l;
          continue;
        }
        //                     people[0] = 70, people[1] = 50, minSum = 10000
        //                 people[0] = 50, people[2] = 80, minSum = 100
        //                 people[0] = 50, people[3] = 50, minSum = 100
        //                 people[1] = 50, people[0] = 50, minSum = 100
        //                 people[1] = 50, people[2] = 50, minSum = 100
        //                 people[1] = 50, people[3] = 50, minSum = 100

        //                 people[2] = 80, people[0] = 70, minSum = 1
        //                 people[2] = 80, people[1] = 50, minSum = 100
        if (people[k] + people[l] <= limit) {
          minSum = Math.min(minSum, people[k] + people[l]);
          minP1 = k;
          minP2 = l;
        }
      }
      if (minSum == 10000) {
        if (k == 0) {
          return people.length;
        } else {
          for (int m = 0; m < people.length; m++) {
            if (people[m] > maxPerson) {
              maxPerson = people[m];
              maxL = m;
            }
          }
          population--;
          countBoat++;
        }
      } else if (minSum != 10000) {
        population -= 2;
        countBoat++;
        minSum = 10000;
      }
    }
    // System.out.println(minP1 + " " + minP2);
    return countBoat;
  }


  public int getOptimal(int x, int y, int limit) {

    return (y > x && y <= limit) ? y : x;
  }

  public int solution(int[] people, int limit) {
    int answer = optimalNum(people, limit, people.length);

    return answer;
  }
}
