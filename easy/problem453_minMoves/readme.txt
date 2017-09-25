[Question]
Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

[Solution]
First, the method of decreasing 1 instead of adding 1 for n-1 elements is brilliant.

First, traverse the array, get the sum and the minimum value. If every element is equal, then min*(len) should equal to sum. This part is easy to understand. So, if they are not equal, what should we do? we should keep adding 1 to the array for k times until min*(len)==sum. Then we have:

len*(min+k)=sum+k*(len-1).
==> k=sum-min*len;
