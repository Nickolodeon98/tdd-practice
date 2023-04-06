package algorithms.samsung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CodeTreeBread {

  //  격자
  public int n, m;
  public int[][] web = new int[n][];

  int[][] convenience = new int[n * n][2];
  int[][] dist = new int[n][];

  int[][] dir = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};

  // 사람
  class Person {

    int currentX;
    int currentY;
    int goalX;
    int goalY;
  }

  Person[] people = new Person[31];

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


    for (int i = 1; i < people.length; i++) {
      String positions = sc.nextLine();
      people[i].goalX = Integer.parseInt(positions.split(" ")[0]);
      people[i].goalY = Integer.parseInt(positions.split(" ")[1]);
    }


  }

  public boolean isInRange(int x, int y) {
    return !(x > n || x < 0 || y > n || y < 0);
  }

  public int process() {
    int count = 1;

    while (!isFinished()) {
      //    Step 1: 1칸 움직임
      for (Person person : people) {
        if (!isArrived(person)) movePerson(person);
      }

      //    Step 2: 도착 여부 확인
      for (Person person : people) {
        checkArrived(person);
      }

      //    Step 3: 사람이 출발하는 곳 -> 베이스캠프 들어간다
      initiate(people[count]);

      count++;
    }

    return count;
  }

  private void initiate(Person person) {

//    BFS(x, y);
    // 모든 거리 중 최단거리를 찾는다.
    int minDist = 10000;
    int x = 0, y = 0;
    for (int k = 0; k < dist.length; k++) {
      for (int d : dist[k]) {
        if (minDist > d) {
          minDist = d;
          x = k;
          y = d;
        }
      }
    }
    person.currentX = x;
    person.currentY = y;
    web[x][y] = -1;
  }

  private void BFS(int x, int y, int[] goal, int[][] map) {
    // 베이스캠프로부터 모든 격자까지의 최단 거리를 구한다.
    Queue<int[]> q = new LinkedList<>();
    boolean[][] visited = new boolean[n][n];
    int[] start = {x, y};
    q.add(start);
    while(!q.isEmpty()) {
      int[] rowAndColumn = q.poll();
      visited[rowAndColumn[0]][rowAndColumn[1]] = true;

      for (int i = 0; i < dir.length; i++) {
        if (!isInRange(x + dir[i][0], y + dir[i][1])) continue;
        if (visited[x + dir[i][0]][y + dir[i][1]]) continue;
        int[] toAdd = {x + dir[i][0], y + dir[i][1]};
        q.add(toAdd);
        visited[x + dir[i][0]][y + dir[i][1]] = true;
      }


      }
    }
  }

  private void movePerson(Person person) {
    // 목표 편의점으로부터 사람 현재 위치의 사방까지의 거리를 구한다
//    BFS();
    int minDist = 10000;
    int x = 0, y = 0;
    // 최단거리를 구한다
    for (int m = 0; m < 4; m++) {
      if (minDist > dist[person.currentX + dir[m][0]][person.currentY + dir[m][1]]) {
        minDist = dist[person.currentX + dir[m][0]][person.currentY + dir[m][1]];
        x = person.currentX + dir[m][0];
        y = person.currentY + dir[m][1];
      }
    }

    person.currentX = x;
    person.currentY = y;
  }

  public void checkArrived(Person person) {
    if (isArrived(person)) {
      web[person.currentX][person.currentY] = -1;
    }
  }

  private boolean isArrived(Person person) {
    return person.currentX == person.goalX && person.currentY == person.goalY;
  }

  public boolean isFinished() {
    for (Person person : people) {
      if (!isArrived(person))
        return false;
    }
    return true;
  }


}
