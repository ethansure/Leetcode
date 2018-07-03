#July 2
class Solution(object):
    def findTargetSumWays(self, nums, S):
        """
        :type nums: List[int]
        :type S: int
        :rtype: int
        """
        sumCounterDict = {0:1}
        for num in nums:
            tdict = {}
            for s in sumCounterDict:
                tdict[s-num] = sumCounterDict.get(s,0) + tdict.get(s-num,0)
                tdict[s+num] = sumCounterDict.get(s,0) + tdict.get(s+num,0)
            sumCounterDict = tdict
        return sumCounterDict.get(S,0)
        
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