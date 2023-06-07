package algorithms.programmers;

public class P60057 {
//     압축을 위해 문자열을 자른다. 앞에서부터 정해진 길이로 똑같이 잘라야 한다.
//     자르는 메서드를 사용해서 개수 단위별로 자르고, Map 에 넣어서 몇 개인지 파악하여 문자열을 새로 생성한다.

  public int addLengths(String[] everything) {
    int lengths = 0;

    for (String e : everything) {
      lengths += e.length();
    }
    return lengths;
  }

  public int squeeze(String target) {
    int mini = 1000;
    String scissor = "";
    String another = "";
    for (int i = 0; i < target.length(); i++) {
      String[] remained = target.split(target.substring(0, i));

      int remainedLengths = addLengths(remained);

      if (remainedLengths + target.substring(0, i).length() < mini) {
        mini = remainedLengths + target.substring(0, i).length();
        scissor = target.substring(0, i);
        if (remained.length != 0) {
          another = remained[remained.length - 1];
          System.out.println(remained[remained.length - 1]);
        }
      }
    }

    for (int j = 0; j < another.length(); j++) {
      String[] anotherRemained = another.split(another.substring(0, j));

      int anotherLengths = addLengths(anotherRemained);

      if (another.substring(0, j).length() == scissor.length()
          && anotherLengths + another.substring(0, j).length() + scissor.length() < mini) {
        mini = anotherLengths + another.substring(0, j).length() + scissor.length();
      }
    }

    System.out.println("scissor: " + scissor + " mini: " + mini + " another: " + another);
    // int onceMore = squeeze(another);

    return mini;

  }

  public int solution(String s) {
    int answer = 0;
    answer = 1 + squeeze(s);
    return answer;
  }

}
