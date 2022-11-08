package algorithms.singlesearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataSearch {
    public int searchData() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> dataSet = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            dataSet.add(sc.nextInt());
        }
        int k = sc.nextInt();

        for (int j = 0; j < dataSet.size(); j++) {
            if (dataSet.get(j) == k) return j+1;
        }

        return -1;
    }

    public static void main(String[] args) {
        DataSearch dataSearch = new DataSearch();
        System.out.println(dataSearch.searchData());
    }
}
