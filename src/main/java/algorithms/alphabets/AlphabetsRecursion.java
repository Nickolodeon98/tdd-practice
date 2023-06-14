package algorithms.alphabets;

public class AlphabetsRecursion {
    public void recursivelyPrintALetter(char letter) {
        if (letter == 'Z'+1) return;
        System.out.println(letter);
        recursivelyPrintALetter(++letter);
    }

    interface Length {
        void printAccordingly(char letter, char start);
    }

    public void recursivelyPrintLetters(char letter, char start, Length length) {
        if (letter > 'Z') return;
        length.printAccordingly(letter, start);
        recursivelyPrintTwoLetters(++letter, start);
    }

    public void recursivelyPrintTwoLetters(char letter, char start) {
        if (letter > 'Z') return;
        System.out.printf("%c%c\n", start, letter);
        recursivelyPrintTwoLetters(++letter, start);
    }

    /* A 에서 Z 까지에서 시작하고 각 문자를 하나씩 증가시키면서 두 글자를 만든다. */
    public void recursivelyPrintNLetters(char letter, Length length) {
        for (char i = 'A'; i <= 'Z'; i++) {
            recursivelyPrintLetters(letter++, i, length);
        }
    }

    public void printAllCases(String prefix) {
        if (prefix.length() > 2) {
            System.out.println(prefix);
            return;
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            printAllCases(prefix + i);
        }
    }

    public static void main(String[] args) {
        AlphabetsRecursion alphabetsRecursion = new AlphabetsRecursion();
//        alphabetsRecursion.recursivelyPrintALetter('A');
//        alphabetsRecursion.recursivelyPrintTwoLetters('A');
//        alphabetsRecursion.recursivelyPrintNLetters('A');
//        alphabetsRecursion.printAllCases("");
//        alphabetsRecursion.recursivelyPrintNLetters('A');
        alphabetsRecursion.recursivelyPrintNLetters('A', (letter, start) -> System.out.printf("%c%c\n", letter, start));
    }
}
