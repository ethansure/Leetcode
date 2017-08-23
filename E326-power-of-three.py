class Solution(object):
    def isPowerOfThree(self, n):
        """
        :type n: int
        :rtype: bool
        """
        maxPowerOfTree = 3 ** 19
        return n > 0 and maxPowerOfTree % n == 0