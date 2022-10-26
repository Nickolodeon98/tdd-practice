package algorithms.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashTableWithNoCollision {
    private int size = 1000;
    private List<Map<String, Integer>>[] table = new ArrayList[size];

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

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put(key, value);
        this.table[position].add(hm);
    }

    public Integer get(String key) {
        int position = hash(key);

        for (Map<String, Integer> node : table[position]) {
            if (node.containsKey(key))
                return node.get(key);
        }
        return null;
    }
}
