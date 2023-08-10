package algorithms.softeer;

import java.io.*;
import java.util.*;

public class S1259 {

  static class Employee {

    Employee junior1;
    Employee junior2;
    Queue<Integer> tasks;

    Employee() {
      junior1 = null;
      junior2 = null;
      tasks = new LinkedList<>();
    }

    Queue<Integer> getTasks() {
      return this.tasks;
    }

    void setJunior1(Employee junior1) {
      this.junior1 = junior1;
    }

    void setJunior2(Employee junior2) {
      this.junior2 = junior2;
    }

    Employee getJunior1() {
      return this.junior1;
    }

    Employee getJunior2() {
      return this.junior2;
    }
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] info = br.readLine().split(" ");

    int H = Integer.valueOf(info[0]);
    int K = Integer.valueOf(info[1]);
    int R = Integer.valueOf(info[2]);

    Employee[] employees = new Employee[(int) Math.pow(2, H)];

    Employee employee = new Employee();

    Queue<Employee> candi = new LinkedList<>();
    candi.offer(employee);

    int h = 0;
    while (h < H) {
      Employee e = candi.poll();

      Employee junior1 = new Employee();
      Employee junior2 = new Employee();

      e.setJunior1(junior1);
      e.setJunior2(junior2);

      candi.offer(e.junior1);
      candi.offer(e.junior2);
      h++;
    }
    System.out.println(employee.getJunior1().getJunior1());

    for (int i = 0; i < employees.length; i++) {
      employees[i] = new Employee();
      String[] line = br.readLine().split(" ");
      for (int j = 0; j < K; j++) {
        employees[i].getTasks().offer(Integer.valueOf(line[j]));
      }
    }

    for (int e = 0; e < employees.length; e++) {
      System.out.println(employees[e].getTasks());
    }
  }

}
