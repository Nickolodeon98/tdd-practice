package algorithms.hash;

import java.util.HashSet;
import java.util.Set;

/* Hash Table determines whereabouts of values depending on what
*  hash function at the moment returns given a key.
*  Both adding a new value and erasing an existing values use Hash Function. */
public class HashTable {
    private int size = 10000;
    private int[] table = new int[size];

    public HashTable() {
    }

    public HashTable(int size) {
        this.size = size;
        this.table = new int[size];
    }

    /* This requires key and value as parameters
     * and use hashed value of key as index to put value. */
    public void insert(String key, int value) {
        int hashedKey = hashFunction(key);
        this.table[hashedKey] = value;
        System.out.println(key + " " + value + "번 방에 저장이 완료되었습니다.");
    }

    public int hashFunction(String s) {
        int asciiSum = 0;
        for (int i = 0; i < s.length(); i++) {
            asciiSum += s.charAt(i);
        }
        return asciiSum % size;
    }

    public static void main(String[] args) {
        String[] names = new String[]{"DongyeonKang",
                "SubinKang", "KwanwunKo", "HyunseokKo", "KyoungdukKoo", "YeonjiGu", "SoyeonKown", "OhsukKwon", "GunwooKim", "KiheonKim", "NayeongKim", "DohyeonKim", "MinkyoungKim", "MinjiKim", "SanghoKim", "SolbaeKim", "YejinKim", "EungjunKim", "JaegeunKim", "JeonghyeonKim", "JunhoKim", "JisuKim", "kimjinah", "HaneulKim", "HeejungKim", "KimoonPark", "EunbinPark", "JeongHoonPark", "JeminPark", "TaegeunPark", "JiwonBae", "SeunggeunBaek", "JihwanByeon", "HeungseopByeon", "JeongHeeSeo", "TaegeonSeo", "SeeYunSeok", "SuyeonSeong", "SeyoelSon", "MinjiSong", "JinwooSong", "hyunboSim", "SominAhn", "JiyoungAhn", "ChangbumAn", "SoonminEom",
                "HyeongsangOh", "SuinWoo", "JuwanWoo", "InkyuYoon", "GahyunLee", "DaonLee", "DohyunLee", "SanghunLee", "SujinLee", "AjinLee", "YeonJae", "HyeonjuLee", "HakjunYim", "SeoyunJang", "SeohyeonJang", "JinseonJang", "SujinJeon", "SeunghwanJeon", "DaehwanJung", "JaeHyunJeung", "HeejunJeong", "GukhyeonCho", "MunjuJo", "YejiJo", "ChanminJu", "MinjunChoi", "SujeongChoi", "SeunghoChoi", "AyeongChoi", "GeonjooHan", "JinhyuckHeo", "MinwooHwang", "SieunHwang",
                "JunhaHwang"};
        HashTable ht = new HashTable(1000);
        Set<Integer> nameSet = new HashSet<>();
        for (int i = 0; i < names.length; i++) {
            nameSet.add(ht.hashFunction(names[i]));
            ht.insert(names[i], ht.hashFunction(names[i]));
        }
        System.out.printf("%d %d", names.length, nameSet.size());
    }
}
