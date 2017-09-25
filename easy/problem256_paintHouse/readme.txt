[Question]
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

[Solution]
This kind of question is very easy and useful.
It actually represents a kind of dynamic programming problem. 
The inheritence is that : 
We don't know whether the current choice is optimal for next stage or not (the difference with greedy problem)? Thus, we delay the decision to make choice for current step at the next step. 
Case:
Stage 1: [0 0] = 1; [0 1] = 5; [0 2] = 6
Stage 2: [1 0] = 1; [0 1] = 15; [0 2] = 17
At stage 1, if we use greedy algorithm, we definitely should choose the red color ([0 0] = 1). Actually this not a global optimal solution, since at stage 2, we have to choose from blue ([0 1] = 15) and green ([0 2] = 17). 
The overall minimum cost for this solution is 16, which is much larger than the best plan: "[0 1] = 5" and "[1 0] = 1".

The problem with this solution is that, we could not make the stage 1's choice based on current information, since it would affect our available choices at stage 2. At current stage, we should only prepare the right information for next stage to directly use, and let the next stage to make choice for the current stage. 

Transitional function:
Assume: 
min_red[i] : the minimum cost to paint houses from 0 to i, iff i was painted with red color. 
min_blue[i] : the minimum cost to paint houses from 0 to i, iff i was painted with blue color. 
min_green[i] : the minimum cost to paint houses from 0 to i, iff i was painted with green color. 

Transitional function. 
min_red[i] = Math.min(min_blue[i-1], min_green[i-1]) + red_cost[i]
We actually made the decision for the previous stage at here. (if i house was painted as red). 

