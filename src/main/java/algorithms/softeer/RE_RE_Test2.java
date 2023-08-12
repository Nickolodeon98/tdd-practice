package algorithms.softeer;

import java.util.ArrayList;
import java.util.Stack;

public class RE_RE_Test2 {

  int vertexCnt;
  ArrayList<Integer>[] edge_List;
  boolean[] visit;
  boolean[] finish;
  Stack<Integer> answer;
  boolean cycle;

  public RE_RE_Test2(int N) {
    this.vertexCnt = N;
    edge_List = new ArrayList[N + 1];
    for (int i = 0; i <= N; ++i) {
      edge_List[i] = new ArrayList<>();
    }
    visit = new boolean[vertexCnt + 1]; //방문 표시
    finish = new boolean[vertexCnt + 1]; //사이클 판단
    answer = new Stack<>(); //결과를 담을 스택
  }

  public void insert_Edge(int from, int to) {
    edge_List[from].add(to);
  }

  public void topological_Sort() {
    //방문하지 않은 정점을 DFS 수행
    for (int i = 1; i <= vertexCnt; ++i) {
      if (cycle) {
        System.out.println("그래프에 사이클 존재");
        return;
      }
      if (!visit[i]) {
        dfs(i);
      }
    }

    //스택에 담긴 정점들을 출력
    while (!answer.isEmpty()) {
      System.out.print(answer.pop() + " ");
    }
  }

  public void dfs(int v) {
    visit[v] = true;

    for (int i = 0; i < edge_List[v].size(); ++i) {
      int nv = edge_List[v].get(i);

      //방문하지 않았으면 dfs 수행
      if (!visit[nv]) {
        dfs(nv);
      }
      //방문한 정점인데 finish 체크가 되지 않았으면 사이클이 존재한다는 의미
      else if (!finish[nv]) {
        cycle = true;
        return;
      }
    }

    //더 이상 갈 곳이 없는 정점을 finish 체크 & 스택에 넣어줌 (말단부터 상위로)
    finish[v] = true;
    answer.push(v);
  }


  public static void main(String[] args) {
    RE_RE_Test2 mg = new RE_RE_Test2(7);
    mg.insert_Edge(1, 2);
    mg.insert_Edge(1, 3);
    mg.insert_Edge(1, 4);
    mg.insert_Edge(2, 5);
    mg.insert_Edge(2, 6);
    mg.insert_Edge(3, 7);
    mg.insert_Edge(3, 6);
    mg.insert_Edge(4, 3);
    mg.insert_Edge(6, 5);
    mg.topological_Sort();
  }

}
