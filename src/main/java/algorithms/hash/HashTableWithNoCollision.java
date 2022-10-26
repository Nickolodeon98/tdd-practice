package algorithms.hash;

import java.util.ArrayList;
import java.util.List;

public class HashTableWithNoCollision {

    class Node {
        private String key;
        private Integer value;

        public Node(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }
    }
    private List<Node>[] table = new ArrayList[1000];

    public int hash(String key) {
        int asciiSum = 0;
        for (int i = 0; i < key.length(); i++) {
            asciiSum += key.charAt(i);
        }
        return asciiSum % 1000;
    }

    public void insert(String key, int value) {
        int hashIdx = hash(key);
        if (this.table[hashIdx] == null)
            this.table[hashIdx] = new ArrayList<>();
        this.table[hashIdx].add(new Node(key, value));
    }
}
