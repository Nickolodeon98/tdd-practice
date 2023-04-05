package algorithms.samsung;

import java.util.Scanner;

public class CodeTreeBread {

  //  격자
  public int n, m;
  public int[][] web = new int[n][];

  int[][] convenience = new int[n * n][2];

  // 사람
  class Person {

    int currentX;
    int currentY;
    int goalX;
    int goalY;
  }

  public void readInput() {
    Scanner sc = new Scanner(System.in);

    String info = sc.nextLine();
    String[] nAndM = info.split(" ");

    n = Integer.parseInt(nAndM[0]);
    m = Integer.parseInt(nAndM[1]);

    int y = 0;
    for (int x = 0; x < web.length; x++) {
      String[] coordinates = sc.nextLine().split(" ");
      while (y < coordinates.length) {
        web[x][y] = Integer.parseInt(coordinates[y]);
        y++;
      }
      y = 0;
    }

    for (int i = 0; i < convenience.length; i++) {
      String positions = sc.nextLine();
      convenience[i][0] = Integer.parseInt(positions.split(" ")[0]);
      convenience[i][1] = Integer.parseInt(positions.split(" ")[1]);
    }
  }

  public void process(Person[] people) {
    while (!isFinished()) {
      //    Step 1: 1칸 움직임
      for (Person person : people) {
        if (person.currentX != person.goalX || person.currentY != person.goalY) {
          movePerson(person);
        }
        //    Step 2: 도착 여부 확인
        if (checkArrived(person)) {
          web[person.currentX][person.currentY] = -1;
        }
        //    Step 3: 출발
        BFS(web);
        initiate(person);
      }

    }


  }

  public boolean checkArrived(Person person) {
    return person.currentX == person.goalX && person.currentY == person.goalY;
  }

  public boolean isFinished() {
    for (int j = 0; )
    if (convenience[j][0])
  }


}
