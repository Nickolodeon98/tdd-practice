package algorithms.bubblesort;

public class ImprovedBubbleSortMain {
    public static void main(String[] args) {
        int[] arr = new int[]{10,50,30,20,40};
        ImprovedBubbleSort bubbleSortImproved = new ImprovedBubbleSort(arr);

        System.out.println(bubbleSortImproved.findSorted());
    }
}
