[Question]
Given an integer n, return the number of trailing zeroes in n!.
Note: Your solution should be in logarithmic time complexity.

[Solution]

factorial
4! = 4*3*2*1 = 24, number of 0 at the end is null
5! = 5*4*3*2*1 = 120, number of 0 at the end is 1

60! -> 
       60 / 5 -> (12)
                  12 / 5 -> (2)
                                (12 + 2) = 14

80! ->
       80 / 5 -> (16)
                  16 / 5 -> (3)
                                (16 + 3) = 19

 


