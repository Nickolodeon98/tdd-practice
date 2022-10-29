package algorithms.hash.programmers;

import java.util.HashSet;

public class P42577 {
    public boolean solution(String[] phone_book) {
        HashSet<String> hashBook = new HashSet<>();

        for (var s : phone_book) hashBook.add(s);
        boolean answer = true;

        /*최초 알고리즘*/
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (hashBook.contains(phone_book[i].substring(0, j))) return answer = false;
            }

        }
        return answer;
    }
}

