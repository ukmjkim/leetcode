import java.util.*;

public class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    ArrayList<Integer> result = new ArrayList<Integer>();

    Arrays.sort(nums1);
    Arrays.sort(nums2);
    
    for (int i = 0; i < nums1.length; i++) {
      if (map.containsKey(nums1[i])) {
        map.put(nums1[i], map.get(nums1[i])+1);
      } else {
        map.put(nums1[i], 1);
      }
    }

    for (int i = 0; i < nums2.length; i++) {
      if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
        result.add(nums2[i]);
        map.put(nums2[i], map.get(nums2[i])-1);
      }
    }

    int[] resultArr = new int[result.size()];
    int k = 0;
    for (Integer num : result) {
      resultArr[k++] = num;
    }
    return resultArr;
  }
  
  public static void main(String[] args) {
    int[] nums1 = {1, 2, 2, 1};
    int[] nums2 = {2, 2};

    Solution solution = new Solution();
    int[] result = solution.intersection(nums1, nums2);
    System.out.println(Arrays.toString(result));
  }
}


