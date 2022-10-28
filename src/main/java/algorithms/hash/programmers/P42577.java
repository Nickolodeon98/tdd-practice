package algorithms.hash.programmers;

import java.util.HashSet;

public class P42577 {
    public boolean solution(String[] phone_book) {
        HashSet<String> hashBook = new HashSet<>();

        for (var s : phone_book) hashBook.add(s);

        /*최초 알고리즘*/
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i+1; j < phone_book.length; j++) {
                if (phone_book[i].indexOf(phone_book[j])) return true;
            }
        }
        return false;
    }
}
