package algorithms.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int front = 0;
        int end = array.length-1;

        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.divideAndSearch(array, 8, front, end));
    }

    public int divideAndSearch(int[] range, int key, int front, int end) {
        int middle = (end - front) / 2;

        if (range[middle] == key) return middle;
        else if (middle == 0) return -1;

        if (range[middle] > key) return divideAndSearch(range, key, front, middle-1);
        else return divideAndSearch(range, key, middle+1, end);
    }
}
