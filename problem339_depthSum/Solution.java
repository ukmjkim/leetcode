import java.util.*;

public class Solution {
  public int depthSum(List<NestedInteger> nestedList) {
    return depthSum(nestedList, 1);
  }
  
  // recursive
  public int depthSum(List<NestedInteger> nestedList, int depth) {
    if (nestedList == null || nestedList.size() == 0) return 0;
    
    int sum = 0;
    for (NestedInteger ni : nestedList) {
      if (ni.isInteger()) {
        sum += ni.getInteger() * depth;
      } else {
        sum += depthSum(ni.getList(), depth + 1);
      }
    }
    return sum;
  }

  // iterative
  public int depthSum2(List<NestedInteger> nestedList) {
    int sum = 0;
    
    Queue <NestedInteger> queue = new LinkedList<>();
    Queue <Integer> depth = new LinkedList<>();
    
    for (NestedInteger ni : nestedList) {
      queue.offer(ni);
      depth.offer(1);
    }
    
    while (!queue.isEmpty()) {
      NestedInteger top = queue.poll();
      int depthNum = depth.poll();
      
      if (top.isInteger()) {
        sum += depthNum*top.getInteger();
      } else {
        for (NestedInteger ni : top.getList()) {
          queue.offer(ni);
          depth.offer(depthNum + 1);
        }
      }
    }
    
    return sum;
  }

  private static void generateNestedInteger1(NestedInteger parent) {
    // [[1,1],2,[1,1]]

    NestedInteger childList1 = new NestedInteger();
    NestedInteger child1 = new NestedInteger(1);
    NestedInteger child2 = new NestedInteger(1);
    childList1.add(child1);
    childList1.add(child2);
    parent.add(childList1);
    parent.add(new NestedInteger(2));

    NestedInteger childList2 = new NestedInteger();
    NestedInteger child3 = new NestedInteger(1);
    NestedInteger child4 = new NestedInteger(1);
    childList2.add(child3);
    childList2.add(child4);
    parent.add(childList2);
  }

  private static void generateNestedInteger2(NestedInteger parent) {
    // [1,[4,[6]]]

    parent.add(new NestedInteger(1));

    NestedInteger childList1 = new NestedInteger();
    NestedInteger child1 = new NestedInteger(4);
    childList1.add(child1);

    NestedInteger childList2 = new NestedInteger();
    NestedInteger child3 = new NestedInteger(6);
    childList2.add(child3);

    childList1.add(childList2);
    parent.add(childList1);
  }

  public static void main(String[] args) {

    Solution obj = new Solution();
    
    NestedInteger parent = new NestedInteger();
    generateNestedInteger1(parent);
    StringBuilder sb = new StringBuilder();
    String result = parent.printNi(parent, sb);
    System.out.printf("depthSum(%s): %d\n", result, obj.depthSum(parent.getList()));

    NestedInteger parent2 = new NestedInteger();
    generateNestedInteger2(parent2);
    StringBuilder sb2 = new StringBuilder();
    String result2 = parent.printNi(parent2, sb2);
    System.out.printf("depthSum(%s): %d\n", result2, obj.depthSum2(parent2.getList()));
  }
}

class NestedInteger {
  private List<NestedInteger> list;
  private Integer integer;

  public NestedInteger() {
    this.list = new ArrayList<>();
  }

  public NestedInteger(Integer integer) {
    this.integer = integer;
  }

  public NestedInteger(List<NestedInteger> list) {
    this.list = list;
  }
  
  public void add(NestedInteger nestedInteger) {
    if (this.list != null) {
      this.list.add(nestedInteger);
    } else {
      this.list = new ArrayList<>();
      this.list.add(nestedInteger);
    }
  }

  public void setInteger(int num) {
    this.integer = num;
  }

  public boolean isInteger() {
    return integer != null;
  }

  public Integer getInteger() {
    return integer;
  }
  
  public List<NestedInteger> getList() {
    return list;
  }
  
  public String printNi(NestedInteger thisNi, StringBuilder sb){
    if(thisNi.isInteger()) {
      sb.append(thisNi.integer);
      sb.append(",");
    }
    sb.append("[");
    for(NestedInteger ni : thisNi.list){
      if(ni.isInteger()) {
        sb.append(ni.integer);
        sb.append(",");
      } else {
        printNi(ni, sb);
      }
    }
    sb.append("]");
    return sb.toString();
  }

}


