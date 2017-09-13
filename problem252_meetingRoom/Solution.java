import java.util.*;

public class Solution {
  public boolean canAttendMeeting(Interval[] intervals) {
    Arrays.sort(intervals, new Comparator<Interval>() {
      @Override
      public int compare(Interval i1, Interval i2) {
        int r = i1.start - i2.start;
        return r == 0 ? i1.end - i2.end : r;
      }
    });
    
    for (int i = 1; i < intervals.length; i++) {
      Interval t1 = intervals[i-1];
      Interval t2 = intervals[i];
      if (t1.end > t2.start) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Interval[] intervals = new Interval[3];;
    intervals[0] = new Interval(0, 30);
    intervals[1] = new Interval(5, 10);
    intervals[2] = new Interval(15, 20);

    Solution solution = new Solution();
    boolean result = solution.canAttendMeeting(intervals);
    System.out.println("Can Attend Meeting?: " + result);

    intervals[0] = new Interval(0, 30);
    intervals[1] = new Interval(35, 50);
    intervals[2] = new Interval(55, 70);
    boolean result2 = solution.canAttendMeeting(intervals);
    System.out.println("Can Attend Meeting?: " + result2);

  }
}

class Interval {
  int start;
  int end;
  public Interval(int _start, int _end) {
    this.start = _start;
    this.end = _end;
  }
}


