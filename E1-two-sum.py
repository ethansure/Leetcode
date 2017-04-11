class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dicts = {}
        for index in range(len(nums)):
            num = nums[index]
            diff = target - num
            if diff in dicts:
                return [dicts[diff], index]
            else:
                dicts[num] = index