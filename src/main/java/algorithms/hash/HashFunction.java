package algorithms.hash;

public class HashFunction {
    /* Core logic in this function exaggerates the use of character variables,
     * conversion into ASCII code composes hash function. */
    public int hash(String key) {
        int asciiSum = 0;
        for (int i = 0; i < key.length(); i++) {
            asciiSum += key.charAt(i);
        }
        return asciiSum % 90;
    }

    public static void main(String[] args) {

    }
}
