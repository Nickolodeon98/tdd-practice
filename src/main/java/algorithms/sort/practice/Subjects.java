package algorithms.sort.practice;

public class Subjects {
  static class Elem implements Comparable<Elem> {

    public String name;
    public int korean, english, math;

    @Override
    public int compareTo(Elem other) {
      return 0;
    }
  }

}
