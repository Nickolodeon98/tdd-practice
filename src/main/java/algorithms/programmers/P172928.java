package algorithms.programmers;

public class P172928 {

  int[] yDir = {0, 0, 1, -1};
  int[] xDir = {1, -1, 0, 0};

  public int[] solution(String[] park, String[] routes) {
    int startY = 0;
    int startX = 0;

    int h = park.length;
    int w = park[0].length();

    for (int i = 0; i < park.length; i++) {
      for (int j = 0; j < park[i].length(); j++) {
        if (park[i].charAt(j) == 'S') {
          startY = i;
          startX = j;
        }
      }
    }
    int nY = startY;
    int nX = startX;
    boolean obs = false;

    for (int m = 0; m < routes.length; m++) {
      String[] info = routes[m].split(" ");
      if (info[0].equals("E")) {
        for (int l = startX; l <= (Integer.valueOf(info[1]) * xDir[0]) + startX; l++) {
          if (l < 0 || l >= w) {
            obs = true;
            nX = startX;
            break;
          }
          if (park[startY].charAt(l) == 'X') {
            obs = true;
            nX = startX;
            break;
          }
          nX = l;
        }
      } else if (info[0].equals("W")) {
        for (int k = startX; k >= (Integer.valueOf(info[1]) * xDir[1]) + startX; k--) {
          if (k < 0 || k >= w) {
            obs = true;
            nX = startX;
            break;
          }
          if (park[startY].charAt(k) == 'X') {
            obs = true;
            nX = startX;
            break;
          }
          nX = k;
        }
      } else if (info[0].equals("S")) {
        for (int n = startY; n <= (Integer.valueOf(info[1]) * yDir[2]) + startY; n++) {
          if (n < 0 || n >= h) {
            obs = true;
            nY = startY;
            break;
          }
          if (park[n].charAt(startX) == 'X') {
            obs = true;
            nY = startY;
            break;
          }
          nY = n;
        }

      } else {
        for (int u = startY; u >= (Integer.valueOf(info[1]) * yDir[3]) + startY; u--) {
          if (u < 0 || u >= h) {
            obs = true;
            nY = startY;
            break;
          }
          if (park[u].charAt(startX) == 'X') {
            obs = true;
            nY = startY;
            break;
          }
          nY = u;
        }
      }
      if (obs) {
        obs = false;
        continue;
      }
      if (info[0].equals("E")) {
        startX = nX;
      } else if (info[0].equals("W")) {
        startX = nX;
      } else if (info[0].equals("S")) {
        startY = nY;
      } else if (info[0].equals("N")) {
        startY = nY;
      }
      obs = false;
    }

    int[] answer = new int[2];
    answer[0] = startY;
    answer[1] = startX;
    return answer;
  }
}
