class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        uns = [1]
        i2 = i3 = i5 = 0
        while n > 1:
            u2 = 2 * uns[i2]
            u3 = 3 * uns[i3]
            u5 = 5 * uns[i5]
            minu = min(u2, u3, u5)
            if u2 == minu:
                i2 += 1
            if u3 == minu:
                i3 += 1
            if u5 == minu:
                i5 += 1
            uns.append(minu)
            n -= 1
        return uns[-1]