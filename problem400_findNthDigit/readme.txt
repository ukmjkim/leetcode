[Question]
Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 2^31).

Example 1:
Input:
3

Output:
3

Example 2:
Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.

[Solution]
1. Analyse

One digit numbers range [1,9](total 9). Two digit numbers range [10,99](total 90). Three digit numbers range [100,999](total 900).

#1 1-9 -> 9
#2 10-99 -> 90                  --> (9 * 1(digit)) + (90 * 2(digit))    ==> 189
#3 100-999 -> 900               --> (9 * 1(digit)) + (90 * 2(digit)) + (900 * 3(digit))   ==> 2889
#4 1000-9999 -> 9000            --> (9 * 1(digit)) + (90 * 2(digit)) + (900 * 3(digit)) + (9000 * 4(digit))   ==> 38889

(i-1) 8(i-1)times 9

start += (n - 1) / len;
The reason why (n-1) is to keep the correct digits finally in number they correspond to. Eg: if we are trying to find the 192th digit, we know range from 1th digit to 9th digit belongs to numbers from 1 to 9 and range from 10th to 189th belongs to numbers from 10 to 99, right? So it is obvious that the next number should be 100 and the 192th digit should be the 3rd digit of 100(now n=3). OK, back to the code, if we donot minus 1 from n and then devide the len, the 192th digit would go to the next number which is 101.

