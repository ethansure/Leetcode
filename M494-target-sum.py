class Solution(object):
    def findTargetSumWays(self, nums, S):
        """
        :type nums: List[int]
        :type S: int
        :rtype: int
        """
        if not nums:
            return 0
        dic = {nums[0]: 1, -nums[0]: 1} if nums[0] != 0 else {0: 2}
        for i in range(1, len(nums)):
            tdict = {}
            for d in dic:
                tdict[d + nums[i]] = tdict.get(d + nums[i], 0) + dic.get(d, 0)
                tdict[d - nums[i]] = tdict.get(d - nums[i], 0) + dic.get(d, 0)
            dic = tdict
        return dic.get(S, 0)