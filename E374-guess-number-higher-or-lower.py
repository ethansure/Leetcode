# The guess API is already defined for you.
# @param num, your guess
# @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
# def guess(num):

class Solution(object):
    def guessNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        low, high= 0, n
        while True:
            num = int((high + low + 1)/2)
            res = guess(num)
            if res == 1:
                low = num
            elif res == -1:
                high = num
            if res == 0:
                break
        return num