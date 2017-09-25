import java.util.*;

public class MyQueue {
  Stack<Integer> stack;

  public MyQueue() {
    stack = new Stack<>();
  }
  
  public void push(int x) {
    Stack<Integer> temp = new Stack<>();
    while (!stack.empty()) {
      temp.push(stack.pop());
    }
    stack.push(x);
    while (!temp.empty()) {
      stack.push(temp.pop());
    }
  }
  
  public int pop() {
    return stack.pop();
  }
  
  public int peek() {
    if (stack.isEmpty()) {
      return 0;
    }
    return stack.peek();
  }
  
  public boolean empty() {
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    MyQueue obj = new MyQueue();
    obj.push(2);
    int param_2 = obj.pop();
    int param_3 = obj.peek();
    boolean param_4 = obj.empty();
  }
}

