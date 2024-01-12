package algorithms.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B18111 {
    static boolean[] visited;
    private static void DFS() {
        for (int i = 0; i < 20; i++) {
            if (visited[i]) break;
            DFS();
        }

        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        visited = new boolean[20];
        String s = br.readLine();
        System.out.println(s);
    }

}
