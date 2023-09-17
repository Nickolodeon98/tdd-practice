package algorithms.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class QueueWithStack {

  static class QueueUsingStack {

    // 입력 용도
    Stack<Integer> stack1;
    // pop 용도
    Stack<Integer> stack2;

    public QueueUsingStack() {
      this.stack1 = new Stack<>();
      this.stack2 = new Stack<>();
    }

    void enqueue(int item) {
      stack1.push(item);
    }

    int dequeue() {
      if (stack2.isEmpty()) {
        while (!stack1.isEmpty()) {
          stack2.push(stack1.pop());
        }
      }
      return stack2.pop();
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.valueOf(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    QueueUsingStack queue = new QueueUsingStack();

    for (int i = 0; i < N; i++) {
      queue.enqueue(Integer.valueOf(st.nextToken()));
    }

    for (int j = 0; j < N; j++) {
      System.out.println(queue.dequeue());
    }
  }

}
