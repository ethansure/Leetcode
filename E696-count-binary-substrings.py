class Solution:
    def countBinarySubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) == 0 or len(s) == 1:
            return 0
        difcount = 0
        i = 0
        a1 = []
        a2 = []
        cur = s[0]
        count = 0
        while i < len(s):
            if cur != s[i]:
                difcount += 1
                cur = s[i]
            if difcount == 0:
                a1.append(s[i])
            elif difcount == 1:
                a2.append(s[i])
            elif difcount == 2:
                count += min(len(a1),len(a2))
                difcount = 1
                a1 = a2
                a2 = [s[i]]
            i+=1
        return count + min(len(a1),len(a2))