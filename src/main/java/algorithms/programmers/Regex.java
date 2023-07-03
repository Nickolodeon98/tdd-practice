package algorithms.programmers;

public class Regex {

  public static void main(String[] args) {
    String s = "ABASADSNFGNBANA";

    s = s.replaceAll("[B{1} | A{3} | N{2}]", "");
    System.out.println(s);
  }

}
