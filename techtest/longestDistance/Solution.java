// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.*;
class Solution {
    public int solution(int[] A) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(A);
        for (int i=1; i < A.length; i++) {
            min = Math.min(min, A[i]-A[i-1]);
        }

        return min;
    }
}

