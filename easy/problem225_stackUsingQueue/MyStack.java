import java.util.*;

public class MyStack {
  Queue<Integer> queue;

  public MyStack() {
    this.queue = new LinkedList<>();
  }
  
  public void push(int x) {
    queue.offer(x);
    for (int i = 0; i < queue.size() - 1; i++) {
      queue.offer(queue.poll());
    }
  }
  
  public int pop() {
    return queue.poll();
  }
  
  
  // primitive data type cannot be null. this will throw NullPointException
  public int top() {
    if (queue.isEmpty()) {
      return 0;
    }
    return queue.peek();
  }
  
  public boolean empty() {
    return queue.isEmpty();
  }
  
  public static void main(String[] args) {
    MyStack obj = new MyStack();
    obj.push(1);
    int param_2 = obj.pop();
    int param_3 = obj.top();
    boolean param_4 = obj.empty();
  }
}

