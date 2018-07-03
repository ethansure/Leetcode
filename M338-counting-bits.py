class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        bs = [0] * (num + 1)
        for i in range(1, num + 1):
            bs[i] = bs[i&(i-1)] + 1
        return bs