class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        n = int(''.join(str(d) for d in digits))
        return [int(i) for i in str(n+1)]