Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

[Solution]
[] 
[1]
	[1,2]						[1,3]           [1,4]
		[1,2,3] [1,2,4]				[1,3,4]
			[1,2,3,4]
[2]
	[2,3] [2,4]
		[2,3,4]
[3]
	[3,4]
[4]

[]
[1]
	[1,2][1,3]
		[1,3]
[2]
	[2,3]
[3]

