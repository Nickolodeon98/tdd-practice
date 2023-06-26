package algorithms.programmers;

import java.util.*;

public class P42839 {


  public ArrayList<Long> storage = new ArrayList<Long>();

  public boolean isPrime(String num) {
    long tmpNum = Long.parseLong(num);

    if (tmpNum == 2) {
      return true;
    }

    if (tmpNum % 2 == 0 || tmpNum == 1 || tmpNum == 0) {
      return false;
    } else {
      for (int j = 3; j <= tmpNum; j += 2) {
        if (tmpNum != j && tmpNum % j == 0) {
          return false;
        }
      }
    }
    return true;
  }


  public int findPrime(ArrayList<String> pieces, ArrayList<String> secret, StringBuilder str,
      int option) {
    int ret = 0;
    ArrayList<String> copy = (ArrayList<String>) pieces.clone();
    ArrayList<String> copy2 = (ArrayList<String>) secret.clone();
    StringBuilder str2 = new StringBuilder(str);

    if (pieces.isEmpty() && secret.isEmpty()) {
      if (!str.toString().isEmpty()) {
        if (isPrime(str.toString())) {
          if (!storage.contains(Long.parseLong(str.toString()))) {
            storage.add(Long.parseLong(str.toString()));
            return 1;
          }
        }
      }
      return 0;
    }
    int count = 0;

    for (int i = 0; i < copy.size(); i++) {
      if (option == 1) {
        str2.append(copy.get(i));
        copy.remove(i);
      }
      if (option == 2) {
        if (copy2.size() > count) {
          str2.append(copy2.get(count));
          copy2.remove(count);
        }
        copy2.add(copy.get(i));
        copy.remove(i);
      }
      if (option == 0) {
        copy.remove(i);
      }

      StringBuilder temp = new StringBuilder(str2);
      StringBuilder temp2 = new StringBuilder(str2);
      StringBuilder temp3 = new StringBuilder(str2);

      ret += findPrime(copy, copy2, temp, 0);
      ret += findPrime(copy, copy2, temp2, 1);
      ret += findPrime(copy, copy2, temp3, 2);

      str2 = new StringBuilder(str);
      copy = (ArrayList<String>) pieces.clone();
      copy2 = (ArrayList<String>) secret.clone();
      count++;
    }

    return ret;
  }

  public int solution(String numbers) {
    int answer = 0;
    String[] divided = numbers.split("(?!^)");
    ArrayList<String> papers = new ArrayList<String>(Arrays.asList(divided));
    ArrayList<String> tmpStorage = new ArrayList<String>();

    StringBuilder sb = new StringBuilder();
    StringBuilder sb2 = new StringBuilder(sb);
    StringBuilder sb3 = new StringBuilder(sb);

    answer += findPrime(papers, tmpStorage, sb, 0);
    answer += findPrime(papers, tmpStorage, sb2, 1);
    answer += findPrime(papers, tmpStorage, sb3, 2);

    return answer;
  }

}
