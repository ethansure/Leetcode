#July 1
class Solution:
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        # canBreak[i] == True means that s[0:i] can be segmented into a space-separated sequence of one or more dictionary words 
        # canBreak[0] equals to True, meaning that '' can be segmented.
        ssize = len(s)
        canBreak = [True] + [False] * ssize
        for endIndex in range(ssize+1):
            for breakIndex in range(endIndex):
                if canBreak[breakIndex] and s[breakIndex:endIndex] in wordDict:
                    canBreak[endIndex] = True
        return canBreak[-1]

#Old Version
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        canBreak = [True] + [False] * len(s)
        for i in range(1,len(s) + 1):
            for j in range(i):
                if s[j:i] in wordDict:
                    if canBreak[j]:
                        canBreak[i] = True
                        break
        return canBreak[-1]