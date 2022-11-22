package algorithms.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddAllElements {
    /* 리스트 맨 앞의 원소를 매번 총합을 저장하는 곳으로 사용한다. 마지막에 맨 앞에는 총합이 있을 것이다. */
    public int getTotal(List<Integer> list) {
        if (list.size() == 1) return list.get(0);
        int toAdd = list.get(0);
        list.remove(0);
        list.set(0, list.get(0) + toAdd); // 0번을 지웠으니 메서드 상위에서 1번이었던 원소가 0번에 내려와있다. 0번 원소를 업데이트한다.
        return getTotal(list);
    }

    public static void main(String[] args) {
        AddAllElements addAllElements = new AddAllElements();
        List<Integer> testNums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        int result = addAllElements.getTotal(testNums);
        System.out.println(result);
    }
}
