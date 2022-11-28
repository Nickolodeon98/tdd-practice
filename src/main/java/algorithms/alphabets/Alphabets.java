package algorithms.alphabets;

public class Alphabets {
    public void everyCaseOneLetter() {
        for (int i = 'A'; i <= 'Z'; i++) {
            char letter = (char) (i);
            System.out.println(letter);
        }

    }

    public void everyCaseTwoLetters() {
        for (int i = 'A'; i <= 'Z'; i++) {
            for (int j = 'A'; j <= 'Z'; j++) {
                char letter = (char) (i);
                char sLetter = (char) (j);
                System.out.printf("%c%c\n", letter, sLetter);
            }
        }
    }

    public static void main(String[] args) {
        Alphabets alphabets = new Alphabets();
        alphabets.everyCaseOneLetter();
        alphabets.everyCaseTwoLetters();
    }
}
