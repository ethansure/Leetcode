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