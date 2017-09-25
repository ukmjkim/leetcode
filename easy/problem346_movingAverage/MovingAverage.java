import java.util.*;

public class MovingAverage {
  Queue<Integer> queue;
  int size;
  int sum;
  
  public MovingAverage(int size) {
    queue = new LinkedList<>();
    this.size = size;
    this.sum = 0;
  }
  
  public double next(int val) {
    queue.offer(val);
    double result = 0;
    sum += val;
    if (queue.size() <= size) {
      result = (double) sum / queue.size();
    } else {
      int remove = queue.poll();
      sum -= remove;
      result = (double) sum / size;
    }

    return result;
  }

  public static void main(String[] string) {
    int num;
    int size = 3;
    MovingAverage mv = new MovingAverage(size);
    
    num = 1;
    System.out.printf("MovingAverage(%d): %.2f\n", num, mv.next(num));

    num = 10;
    System.out.printf("MovingAverage(%d): %.2f\n", num, mv.next(num));

    num = 3;
    System.out.printf("MovingAverage(%d): %.2f\n", num, mv.next(num));

    num = 5;
    System.out.printf("MovingAverage(%d): %.2f\n", num, mv.next(num));
  }
}

