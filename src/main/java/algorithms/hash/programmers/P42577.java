package algorithms.hash.programmers;

import java.util.HashSet;

public class P42577 {
    public boolean solution(String[] phone_book) {
        public boolean solution(String[] phone_book) {
            HashSet<String> hashBook = new HashSet<>();

            for (var s : phone_book) hashBook.add(s);
            boolean answer = true;
            /*최초 알고리즘*/
            for (int i = 0; i < phone_book.length; i++) {
                for (int j = 0; j < phone_book.length; j++) {
                    // System.out.println(phone_book[i]);
                    // System.out.println(phone_book[j]);
                    if (!phone_book[i].equals(phone_book[j]) && phone_book[i].indexOf(phone_book[j]) == 0) answer = false;
                }
            }
            return answer;
        }
}
