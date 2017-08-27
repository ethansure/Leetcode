class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        preSum, curSum = 0, 0
        for i in nums: 
            preSum, curSum = curSum, max(preSum + i, curSum)
        return curSum