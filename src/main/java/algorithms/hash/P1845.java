package algorithms.hash;

import java.util.HashSet;
import java.util.Set;

public class P1845 {

    /* toSelect 에 선택해야 할 개수를 저장한다.
     * 6마리면 3이고 4마리이면 2이다.
     * 선택했을 때 모두 다른 종류가 나오는 것이 최선이다.
     * 이는 HashSet 의 길이가 toSelect 보다 작을 때 HashSet 의 길이가 리턴되어야 함을 의미한다.
     * 만약 HashSet 의 길이가 더 길거나 같다면? toSelect 를 리턴하면 된다. (같을 때는 뭘 리턴하던지 상관없다.)*/
    public int solution(int[] nums) {
        Set<Integer> pokemon = new HashSet<>();
        int toSelect = nums.length / 2;
        for (int num : nums) {
            pokemon.add(num);
        }
        if (toSelect > pokemon.size()) return pokemon.size();
        else return toSelect;
    }

    public static void main(String[] args) {
        P1845 p1845 = new P1845();
        int[] nums = {3,3,3,2,2,4};
        System.out.println(p1845.solution(nums));
    }
}