[Question]
There is a fence with n posts, each post can be painted with one of the k colors. You have to paint all the posts such that no more than two adjacent fence posts have the same color. Return the total number of ways you can paint the fence.

[Solution]
The key to solve this problem is finding this relation.

f(n) = (k-1)(f(n-1)+f(n-2))

Assuming there are 3 posts, if the first one and the second one has the same color, then the third one has k-1 options. The first and second together has k options.
If the first and the second do not have same color, the total is k * (k-1), then the third one has k options. Therefore, f(3) = (k-1)*k*1 + k*(k-1)*k = (k-1)(k+k*k)

f(3) = same color + different color
     (k-1)*k*1       k*(k-1)*k

// Assume that there are 3 colors
// 0 house, 0
// 1 house, k
// 2 house, same color = k*1, different color = k*(k-1)
//      -> k + k*(k-1)
// 3 house, different (k-1) (1) 1st 2 the same
//                          (2) lst 2 different
//      -> different = (same + different) * (k-1)
//      -> same = (different) * 1


