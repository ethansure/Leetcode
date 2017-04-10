class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        maxResult = nums[0]
        maxProd = nums[0]
        minProd = nums[0]
        for index in range(1,len(nums)):
            num = nums[index]
            previousMax = maxProd
            maxProd = max(maxProd*num,num,minProd*num)
            minProd = min(minProd*num,num,previousMax*num)
            maxResult = max(maxResult, maxProd)
        return maxResult