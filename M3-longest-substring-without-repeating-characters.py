class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        windowStr = ''
        maxLength = 0
        for item in s:
            previousStr = windowStr
            windowStr += item
            if item in previousStr:
                itemIndex = windowStr.index(item)
                windowStr = windowStr[itemIndex+1:len(windowStr)]
            maxLength = max(maxLength,len(windowStr))
        return maxLength
