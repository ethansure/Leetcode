class Solution(object):
    def thirdMax(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort(reverse=True)
        compat = [nums[0]]
        for index in range(1,len(nums)):
            num = nums[index]
            if compat[len(compat) - 1] != num:
                compat.append(num)
        return compat[2] if len(compat) >= 3 else compat[0]
        