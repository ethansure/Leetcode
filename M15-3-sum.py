class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        triplets = []
        l = len(nums)
        for i in range(0, l - 2):
            if i > 0 and nums[i - 1] == nums[i]:
                continue
            left = i + 1
            right = l - 1
            while left < right:
                nsum = nums[i] + nums[left] + nums[right]
                if nsum < 0:
                    left += 1
                elif nsum > 0:
                    right -= 1
                else:
                    triplets.append((nums[i],nums[left],nums[right]))
                    left += 1
                    right -= 1
                    while left < right and nums[left] == nums[left - 1]:
                        left += 1
                    while right > left and nums[right] == nums[right + 1]:
                        right -= 1
        return triplets