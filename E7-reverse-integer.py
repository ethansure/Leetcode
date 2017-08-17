class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        negative = -1 if x < 0 else 1
        s = str(negative * x)[::-1]
        rev = int(s) * negative
        return rev if rev <= 1 << 31 and rev >= ~(1 << 31) else 0