class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        s = '1'
        for _ in range(n-1):
            l, ss, count = s[0], '', 0
            for i in s:
                if l == i:
                    count += 1
                else:
                    ss += str(count)+l
                    l = i
                    count = 1
            ss += str(count)+l
            s = ss
        return s