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

    public Integer get(String key) {
        int size = this.table[hash(key)].size();
        for (int i = 0; i < size; i++) {
            if (this.table[hash(key)].get(i).getKey().equals(key))
                return this.table[hash(key)].get(i).getValue();
        }
        return null;
    }

    public static void main(String[] args) {
        HashTableWithNoCollision hashTableWithNoCollision = new HashTableWithNoCollision();

        hashTableWithNoCollision.insert("Yoonseo", 1);
        hashTableWithNoCollision.insert("Seoyoon", 2);


        if (hashTableWithNoCollision.get("Seoyoon") == 2) System.out.println("테스트 성공");
        else System.out.println("테스트 실패");

        if (hashTableWithNoCollision.get("Yoonseo") == 1) System.out.println("테스트 성공");
        else System.out.println("테스트 실패");
    }
}
