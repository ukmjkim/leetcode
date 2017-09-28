import java.util.*;

public class BinarySearchTree <T extends Comparable<T>> {
  private TreeNode<T> root;
  private Comparator<T> comparator;

  public BinarySearchTree() {
    this.root = null;
    this.comparator = null;
  }

  public BinarySearchTree(Comparator<T> comp) {
    this.root = null;
    this.comparator = comp;
  }

  private int compare(T x, T y) {
    if (comparator == null) return x.compareTo(y);
    else return comparator.compare(x, y);
  }

  public void insert(T data) {
    root = insert(root, data);
  }

  private TreeNode<T> insert(TreeNode<T> p, T data) {
    if (p == null) return new TreeNode<T>(data);

    if (compare(data, p.getData()) < 0) {
      p.setLeftNode(insert(p.getLeftNode(), data));
    }
    else if (compare(data, p.getData()) > 0) {
      p.setRightNode(insert(p.getRightNode(), data));
    }

    return p;
  }

  public boolean search(T data) {
    return search(root, data);
  }

  private boolean search(TreeNode<T> p, T data) {
    if (p == null) return false;

    if (compare(data, p.getData()) == 0)
      return true;
    else if (compare(data, p.getData()) < 0)
      return search(p.getLeftNode(), data);
    else if (compare(data, p.getData()) > 0)
      return search(p.getRightNode(), data);

    return false;
  }

  public String tree2str() {
    return tree2str(root);
  }

  private String tree2str(TreeNode<T> p) {
    if (p == null) return "";

    String result = p.getData() + "";
    String left = tree2str(p.getLeftNode());
    String right = tree2str(p.getRightNode());

    if (left == "" && right == "") return result;
    if (left == "") return result + "()" + "(" + right + ")";
    if (right == "") return result + "(" + left + ")";
    return result + "(" + left + ")" + "(" + right + ")";
  }

  public static void main(String[] args) {
    Integer[] intArr = {1, 5, 2, 7, 4};
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    for (Integer num : intArr) {
      System.out.printf("%s ", num);
      bst.insert(num);
    }
    System.out.println();
    System.out.println(bst.tree2str());
    System.out.println(bst.search(5));

    String[] strArr = {"Apple", "Mango", "Pear", "Peach", "Grapes"};
    BinarySearchTree<String> bst2 = new BinarySearchTree<>();
    for (String str : strArr) {
      System.out.printf("%s ", str);
      bst2.insert(str);
    }
    System.out.println();
    System.out.println(bst2.tree2str());
    System.out.println(bst2.search("Apple"));
  }
}

class TreeNode<T> {
  private T data;
  private TreeNode<T> left;
  private TreeNode<T> right;
  TreeNode (T data) { this.data = data; }
  public T getData() { return data; }
  public TreeNode<T> getLeftNode() { return left; }
  public TreeNode<T> getRightNode() { return right; }
  public void setLeftNode(TreeNode<T> left) { this.left = left; }
  public void setRightNode(TreeNode<T> right) { this.right = right; }
}
