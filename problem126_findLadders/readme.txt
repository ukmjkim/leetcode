[Question]
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cob"
wordList = ["hot","dot","dog","lot","log","cog", "cob"]
Return

  [
    ["hit","hot","dot","dog","cog", "cob"],
    ["hit","hot","lot","log","cog", "cob"]
  ]

Note:
	Return an empty list if there is no such transformation sequence.
	All words have the same length.
	All words contain only lowercase alphabetic characters.
	You may assume no duplicates in the word list.
	You may assume beginWord and endWord are non-empty and are not the same.



hit ---- hot----- lot ----- log ----- cog ---- cob
          \                          /
            \                      /
              \                  /
                  dot ----- dog


http://www.jianshu.com/p/ece0d5d441dc
http://javabypatel.blogspot.ca/2015/10/word-ladder-doublets-word-links-word-golf.html

