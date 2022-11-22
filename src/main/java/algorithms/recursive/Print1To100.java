package algorithms.recursive;

public class Print1To100 {
    public void print(int i) {
        if (i > 100) return;
        try {
            System.out.println(i);
            print(++i);
        } catch (StackOverflowError e) { // 메시지가 한없이 출력되고 출력이 꼬이다가 어느 순간에 출력되기 때문에 한 줄에 문자열들이 서로 정해진 순서 없이 출력된다.
            System.out.println(e.getMessage());
            System.out.println("스택 오버플로우 에러가 발생했습니다.");
//            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Print1To100 print1To100 = new Print1To100();
        print1To100.print(1);
    }
}
