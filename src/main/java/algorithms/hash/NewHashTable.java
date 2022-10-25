package algorithms.hash;

public class NewHashTable {
    private int size = 10000;
    private int[] table = new int[size];

    public NewHashTable() {
    }

    public NewHashTable(int size) {
        this.size = size;
        this.table = new int[size];
    }

    public int hash(String key) {
        int sumOfChars = 0;
        for (int i = 0; i < key.length(); i++) {
            sumOfChars += key.charAt(i);
        }
        return sumOfChars % size;
    }

    public void insert(String key, int value) {
        this.table[hash(key)] = value;
        System.out.printf("%s님의 값 %d는 %d번 방에 저장 완료되었습니다.\n", key, value, hash(key));
    }

    public int search(String key) {
        return table[hash(key)];
    }

    public static void main(String[] args) {
        NewHashTable newHashTable = new NewHashTable(1000);
        newHashTable.insert("Seunghwan", 1);
        System.out.println(newHashTable.search("Seunghwan"));
    }
}
