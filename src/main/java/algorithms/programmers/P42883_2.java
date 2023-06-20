package algorithms.programmers;

import java.util.*;

public class P42883_2 {

//     k 개의 수를 제거했을 때 얻을 수 있는 가장 큰 수
//  길이 - k  만큼 숫자가 있어야 함
//     예를 들면, number 의 길이가 4이고 k 가 2이면 return 값은 4 - 2 의 길이를 가짐
//     항상 뒤에 남은 길이를 생각하면서 위에 남은 길이를 활용해서 충족되는 return 값의 길이를 맞추지 못하게 될 것 같으면 뒤에 있는 숫자를 모두 활용
//     현재 숫자 다음 붙일 숫자를 추적하는 포인터를 하나 생성함
//     nextNumPtr
//     number.length() - k 만큼의 길이 = goalLength
//     curLength = curWord.length()
//     curLength 가 goalLength 와 같아지기 전까지는 계속해서 curWord 에 number 의 숫자를 붙임
//     남은 길이는 remains 에 저장

  int[] numbers;

  public StringBuilder createNum(String number, int k) {
    // System.out.println(number);
//         먼저 포인터와 충족해야 하는 남은 길이를 변수로 초기화한다.
    int nextNumPtr = 0;
    int maxNumPtr = 0;
    int remains = number.length() - k;
    StringBuilder curWord = new StringBuilder();
//         문자열을 배열로 변환한다.
    // char[] numbers = number.toCharArray();
//         문자열의 첫번째 문자를 현재 참조하고 있는 숫자로 배정한다.
    int curNum = numbers[nextNumPtr];
    int cnt = 0;

    int idx = nextNumPtr;
//         숫자의 길이만큼에서 다음 포인터의 위치를 빼고 남은 숫자의 길이가 충족되어야 하는 숫자보다 많은 한 계속 비교한다.
    while (remains > 0) {
      while (numbers.length - idx - cnt > remains) {
        nextNumPtr++;
        cnt++;
        //                 여유가 있으면 안 붙이고 잠시 미뤄두지만 여유가 없다면 붙여야한다.
        //             만약 현재 배열에서 참조하는 숫자가 더 크면, 그 때에는 이전 숫자를 버리고 지금 숫자를 붙여준다.
        if (numbers[nextNumPtr] > curNum) {
          //                     현재 것이 이전 것보다 더 크다는 결론이 나면
          //                 현재 숫자를 업데이트 해준다.
          curNum = numbers[nextNumPtr];
          //                  최대 숫자가 위치한 곳을 추적한다.
          maxNumPtr = nextNumPtr;
        }
      }
      // 현재 보고 있는 숫자 문자열에 새로운 최대값을 더해준다.
      curWord.append(curNum);
      nextNumPtr = maxNumPtr + 1;
      maxNumPtr++;
      if (nextNumPtr < numbers.length) {
        curNum = numbers[nextNumPtr];
      }
      cnt = 0;
      idx = nextNumPtr;
      remains--;
    }
//         maxNumPtr 의 위치는 항상 바뀌어야 한다. 만약 바뀌지 않으면 오류가 난다. 왜냐하면 예전과는 다른 시작점이 있었는데 아직까지 같은 곳을 바라보고 있기 때문이다. 즉, 이미 끝난 이후에는
    return curWord;
  }

  public String solution(String number, int k) {
    String answer = "";
    StringBuilder sb = new StringBuilder();
    char[] singleNums = number.toCharArray();
    numbers = new int[singleNums.length];
    for (int i = 0; i < singleNums.length; i++) {
      numbers[i] = singleNums[i] - '0';
    }

    answer = createNum(number, k).toString();
    return answer;

  }

}
