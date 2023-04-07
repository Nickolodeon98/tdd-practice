package algorithms.samsung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CodeTreeBread {

  //  격자
  public int n, m;

  public void setN(int n) {
    this.n = n;
  }

  public void setM(int m) {
    this.m = m;
  }

  public int[][] web = new int[20][20];

//  int[][] dist = new int[20][20];

  int[][] dir = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};

  // 사람
  class Person {

    public Person() {
      this.currentX = 0;
      this.currentY = 0;
      this.goalX = 0;
      this.goalY = 0;
    }

    int currentX;
    int currentY;
    int goalX;
    int goalY;

    public void setCurrentX(int currentX) {
      this.currentX = currentX;
    }

    public void setCurrentY(int currentY) {
      this.currentY = currentY;
    }

    public Person(int currentX, int currentY, int goalX, int goalY) {
      this.currentX = currentX;
      this.currentY = currentY;
      this.goalX = goalX;
      this.goalY = goalY;
    }
  }

  Person[] people = new Person[31];

  public Person[] readInput() {
    Scanner sc = new Scanner(System.in);

    String info = sc.nextLine();
    String[] nAndM = info.split(" ");

    setN(Integer.parseInt(nAndM[0]));
    setM(Integer.parseInt(nAndM[1]));

    for (int num = 1; num <= m; num++) {
      people[num] = new Person();
    }
    String[] coordinates = new String[n];

    int y = 1;
    for (int x = 1; x <= n; x++) {
      coordinates = sc.nextLine().split(" ");

      while (y <= coordinates.length) {
//        System.out.println(coordinates[y-1]);
        web[x][y] = Integer.parseInt(coordinates[y-1]);
        y++;
      }
//      for (String s : coordinates) {
//        System.out.print(s + " ");
//      }
//      System.out.println();
      y = 1;
    }


    for (int i = 1; i <= m; i++) {
      String positions = sc.nextLine();
      people[i].goalX = Integer.parseInt(positions.split(" ")[0]);
      people[i].goalY = Integer.parseInt(positions.split(" ")[1]);
    }

    return people;
  }

  public boolean isInRange(int x, int y) {
    return x <= n && x >= 1 && y <= n && y >= 1;
  }

  public int process() {
    Person[] people = readInput();

//    System.out.println("memoization: " + m);
//    for (int[] row : web) {
//      for (int column : row)
//        System.out.print(column + " ");
//      System.out.println();
//    }

    for (int i = 1; i <= m; i++) {
//      System.out.println("initialGoalX: " + people[i].goalX);
//      System.out.println("initialCurrentX: " + people[i].currentX);
//      System.out.println("initialGoalY: " + people[i].goalY);
//      System.out.println("initialCurrentY: " + people[i].currentY);
    }

    int count = 0;

    while (!isFinished(people)) {
      count++;

      //    Step 1: 1칸 움직임
      for (int i = 1; i < count && i <= m; i++) {
        if (!isArrived(people[i])) {
          Person person = movePerson(people[i]);
          people[i] = new Person(person.currentX, person.currentY, person.goalX, person.goalY);
//          System.out.println("cX: " + people[i].currentX + "m: " + m);
//          System.out.println("gX: " + people[i].goalX);
//          System.out.println("cY: " + people[i].currentY);
//          System.out.println("gY: " + people[i].goalY);
        }
      }

      //    Step 2: 도착 여부 확인
      for (int j = 1; j < count && j <= m; j++) {
        web = checkArrived(people[j], web);
      }

      //    Step 3: 사람이 출발하는 곳 -> 베이스캠프 들어간다
      if (m >= count) {
//        System.out.println("hereherehere");
        int[] xAndY = initiate(people[count], web);
        people[count].setCurrentX(xAndY[0]);
//        System.out.println("toChangeX: " + xAndY[0]);
//        System.out.println("changedX: " + people[count].currentX);
        people[count].setCurrentY(xAndY[1]);
//        System.out.println("changedY: " + people[count].currentY);
//        System.out.println("toChangeY: " + xAndY[1]);
        web[xAndY[0]][xAndY[1]] = -1;
      }
//      System.out.println("Count: " + count);
    }

    return count;
  }

  public int[] initiate(Person person, int[][] web) {
//    System.out.println("this is n: " + n);
//    System.out.println("web[2][1]: " + web[2][1]);
    int[][] dist = BFS(person.goalX, person.goalY);

//    for (int[] row : dist) {
//      for (int column : row)
//        System.out.print(" " + column);
//      System.out.println();
//    }

    // 모든 거리 중 최단거리를 찾는다.
    int minDist = 10000;
    int minX = 0, minY = 0;
    for (int k = 1; k <= n; k++) {
      for (int l = 1; l <= n; l++) {
        if (web[k][l] != 1) {
//          System.out.println("continued with: " + web[k][l]);
          continue;
        }
//        System.out.println("not continued: " + dist[k][l]);
        if (minDist > dist[k][l]) {
          minDist = dist[k][l];
          minX = k;
          minY = l;
        }
      }
    }
    int[] coords = new int[2];
    coords[0] = minX;
    coords[1] = minY;
    return coords;
  }

  private int[][] BFS(int x, int y) {
    // 베이스캠프로부터 모든 격자까지의 최단 거리를 구한다.
    Queue<Integer> q = new LinkedList<>();
    int[][] dist = new int[20][20];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        dist[i][j] = 10000;
      }
    }

    q.add(x);
    q.add(y);
    dist[x][y] = 0;

    while (!q.isEmpty()) {
      int row = q.poll();
      int column = q.poll();
      for (int i = 0; i < dir.length; i++) {
        int nx = row + dir[i][0], ny = column + dir[i][1];
        if (!isInRange(nx, ny)) {
          continue;
        }
        if (dist[nx][ny] != 10000) {
          continue;
        }
        if (web[nx][ny] == -1) {
          continue;
        }
        q.add(nx);
        q.add(ny);
        dist[nx][ny] = dist[row][column] + 1;
      }
    }
//    for (int[] row : dist) {
//      for (int column : row)
//        System.out.print(" " + column);
//      System.out.println();
//    }

    return dist;
  }

  private Person movePerson(Person person) {
    // 목표 편의점으로부터 사람 현재 위치의 사방까지의 거리를 구한다
    int[][] dist = BFS(person.goalX, person.goalY);
    int minDist = 10000;
    int minX = 0, minY = 0;
    // 최단거리를 구한다
    for (int m = 0; m < 4; m++) {
      int px = person.currentX + dir[m][0], py = person.currentY + dir[m][1];
      if (!isInRange(px, py)) {
//        System.out.println("pass");
        continue;
      }
      if (minDist > dist[px][py]) {
//        System.out.println("update");
        minDist = dist[px][py];
        minX = px;
        minY = py;
      }
    }

//    System.out.println("minDist: " + minDist);
//    System.out.println("minX: " + minX);
//    System.out.println("minY: " + minY);

    person.setCurrentX(minX);
    person.setCurrentY(minY);
    return person;
  }

  public int[][] checkArrived(Person person, int[][] web) {
    if (isArrived(person)) {
      web[person.currentX][person.currentY] = -1;
    }

    return web;
  }

  private boolean isArrived(Person person) {
//    System.out.println("currentX: " + person.currentX);
//    System.out.println("goalX: " + person.goalX);
//    System.out.println("currentY: " + person.currentY);
//    System.out.println("goalY: " + person.goalY);
    return person.currentX == person.goalX && person.currentY == person.goalY;
  }

  public boolean isFinished(Person[] people) {
    for (int i = 1; i <= m; i++) {
      if (!isArrived(people[i])) {
//        System.out.println("hello");
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    CodeTreeBread solution = new CodeTreeBread();
    int answer = solution.process();
//    System.out.println(answer);
  }

}
