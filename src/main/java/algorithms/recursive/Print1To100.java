package algorithms.recursive;

public class Print1To100 {
    public void print(int i) {
//        if (i > 100) return;
        try {
            System.out.println(i);
            print(i);
        } catch (StackOverflowError e) {
            System.out.println(e.getMessage());
//            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Print1To100 print1To100 = new Print1To100();
        print1To100.print(1);
    }
}
