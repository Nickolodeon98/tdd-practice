package algorithms.hash;

import java.util.ArrayList;
import java.util.List;

public class HashTableWithNoCollision {

    class Node {
        private String key;
        private int value;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }

    private int size = 1000;
    private List<Node>[] table = new ArrayList[size];

    public HashTableWithNoCollision() {
    }

    public HashTableWithNoCollision(int size) {
        this.size = size;
        this.table = new ArrayList[size];
    }

    public int hash(String key) {
        int asciiSum = 0;

        for (int i = 0; i < key.length(); i++) {
            asciiSum += key.charAt(i);
        }
        return asciiSum % size;
    }

    public void insert(String key, int value) {
        int position = hash(key);
        if (this.table[position] == null)
            this.table[position] = new ArrayList<>();
        this.table[position].add(new Node(key, value));
    }

    public Integer get(String key) {
        int position = hash(key);

        for (Node node : table[position]) {
            String registeredKey = node.getKey();
            if (registeredKey.equals(key))
                return node.getValue();
        }
        return null;
    }
}
