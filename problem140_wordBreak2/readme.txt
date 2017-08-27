Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].



graph
{0=[], 1=[], 2=[], 3=[cat], 4=[cats], 5=[], 6=[], 7=[sand, and], 8=[], 9=[], 10=[dog, dog]}
                                                                                ---> without visited

