[Question]
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:
Input: 16
Returns: True

Example 2:
Input: 14
Returns: False

[Solution]
A # that is the product of 2 identical factors. We can use primefactorization.

1,     4,     9,     16,       25,          36, 49, 64, 81, 100
|      |      |       |        |             |
1*1  2*2     3*3     4*4       5*5          6*6


    24            prime#   1, 2, 3, 5, 7, 11, 13..
   2  12
     2  6
       2  3

