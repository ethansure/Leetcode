class Solution(object):
    def isUgly(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num == 0:
            return False
        quotient = num
        for prime in [2,3,5]:
            while quotient % prime == 0:
                quotient = quotient // prime
        return quotient == 1