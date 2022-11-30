package algorithms.binarytree;

public class CountPAndY {
    public boolean count(String s) {
        String unified = s.toLowerCase();
        int countP = 0;
        int countY = 0;
        for (int i = 0; i < unified.length(); i++) {
            if (unified.charAt(i) == 'p') countP++;
            if (unified.charAt(i) == 'y') countY++;
        }
        return countP == countY;
    }
}
