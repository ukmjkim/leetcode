public class MaximumTest {
  // determines the largest of three Comparable objects

  public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
    // assume x is intially the largest
    T max = x;

    if (y.compareTo(max) > 0) {
      max = y;
    }

    if (z.compareTo(max) > 0) {
      max = z;
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5, maximum(3, 4, 5));
    System.out.printf("Max of %f, %f and %f is %f\n\n", 3.3, 4.4, 5.5, maximum(3.3, 4.4, 5.5));
    System.out.printf("Max of %s, %s and %s is %s\n\n", "apple", "pear", "banana", maximum("banana", "apple", "pear"));
  }
}

