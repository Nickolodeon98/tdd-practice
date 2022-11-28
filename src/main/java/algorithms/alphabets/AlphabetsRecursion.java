package algorithms.alphabets;

public class AlphabetsRecursion {
    public void recursivelyPrintALetter(char letter) {
        if (letter == 'Z'+1) return;
        System.out.println(letter);
        recursivelyPrintALetter(++letter);
    }

    public static void main(String[] args) {
        AlphabetsRecursion alphabetsRecursion = new AlphabetsRecursion();
        alphabetsRecursion.recursivelyPrintALetter('A');
    }
}
