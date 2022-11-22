package algorithms.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddAllElements {
    /* 리스트 맨 앞의 원소를 매번 총합을 저장하는 곳으로 사용한다. 마지막에 맨 앞에는 총합이 있을 것이다. */
    public int getTotal(List<Integer> list) {
        if (list.size() == 1) return list.get(0);
        /* 아래 두 줄은 한 줄로 바꿀 수 있다. remove 는 삭제된 원소를 반환하기 때문이다. */
        int toAdd = list.get(0);
        list.remove(0);

        list.set(0, list.get(0) + toAdd); // 0번을 지웠으니 메서드 상위에서 1번이었던 원소가 0번에 내려와있다. 0번 원소를 업데이트한다.
        return getTotal(list);
    }

    public int getSum(List<Integer> list) {
        if (list.isEmpty()) return 0; // 리스트가 비었으면 더 이상의 연산은 하지 않는다.
        /* 리스트가 비지 않았다면 맨 아래와 같이 덧셈을 해준다.
         * 바뀌는 부분은 list 의 remove 메서드를 사용한다.
         * 밑의 두 줄은 한 줄로 바꿀 수 있다. lastElement 를 사용하지 않을 수도 있다. */
        int lastElement = list.remove(list.size()-1); // 맨 마지막 원소를 삭제한다. 삭제한 후에는 리스트의 사이즈가 1 줄어든다. 맨 마지막 원소의 인덱스도 함께 줄어든다.
        return lastElement + getSum(list); // 재귀 호출을 통해 + 뒤의 부분을 변화시키며 현재까지의 총합에다가 계속해서 합한다. 결국 모든 원소들을 돌며 더하게 된다.
    }

    public static void main(String[] args) {
        AddAllElements addAllElements = new AddAllElements();
        List<Integer> testNums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        int result = addAllElements.getSum(testNums);
        System.out.println(result);
    }
}
