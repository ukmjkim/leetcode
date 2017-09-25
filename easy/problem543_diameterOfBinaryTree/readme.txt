[Question]
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.


[Solution]
What is diameter of binary tree?
the number of nodes on the longest path in a binary tree.

4 -> 2 -> 1 -> 3 => the end node in the left to the end node in the right. (the height of the left tree + the height of the right tree)
  1    2    3

lheight + rheight + 1 (if the diameter passes through root)

if tree is not balanced then the longest path does not include root.

max(ldiameter, rdiameter) (if the idameter doesn't pass through root)

