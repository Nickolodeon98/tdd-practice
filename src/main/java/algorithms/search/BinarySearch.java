package algorithms.search;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int front = 0;
        int end = array.length-1;
        Scanner sc = new Scanner(System.in);
        System.out.print("찾고 싶은 숫자를 입력하세요.\n>>> ");
        int key = sc.nextInt();

        BinarySearch binarySearch = new BinarySearch();
        System.out.printf("찾으시는 숫자는 배열의 %d번 위치에 있습니다.\n", binarySearch.divideAndSearch(array, key, front, end));
    }

    public int divideAndSearch(int[] range, int key, int front, int end) {
        int middle = (end + front) / 2;
        // 중간값을 찾을 때 range 배열의 크기는 변하지 않으므로 인덱스 값 참조를 위해
        // end - front / 2 가 아닌 end + front / 2 이다.

        if (range[middle] == key) return middle;
        else if (end - front <= 0) return -1;

        if (range[middle] > key) return divideAndSearch(range, key, front, middle-1);
        else return divideAndSearch(range, key, middle+1, end);
    }
}
