[Question]
Given an integer, write a function to determine if it is a power of two.

[Solution]
The binary representation of a power-of-two 2y is a 1 followed only by 0s.
In such a case, x − 1 generates a binary number where the 1s turn into 0s and the former 0s turn into 1s.
For example, 8 = 1000b and 8 − 1 = 7 = 0111b.

If x and x − 1 are binary ANDed then the result is only 0 if x is a power of two

