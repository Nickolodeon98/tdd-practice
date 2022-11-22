package algorithms.recursive;

public class GetTotalArray {
    /* 우선 현재 참조하고 있는 인덱스가 어디인지를 매개 변수를 통해 알아야 한다. */
    public int totalOfElements(int[] arr, int index) {
        if (index == arr.length) return 0;
        return arr[index] + totalOfElements(arr, ++index);
    }

    public static void main(String[] args) {
        GetTotalArray getTotalArray = new GetTotalArray();
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        int result = getTotalArray.totalOfElements(nums, 0);
        System.out.println(result);
    }
}
