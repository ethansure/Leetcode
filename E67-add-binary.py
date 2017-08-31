class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        al = len(a)
        bl = len(b)
        l = max(al, bl)
        res = []
        carry = 0
        for i in range(0, l):
            ai = al - i - 1
            bi = bl - i - 1
            isum = 0 + carry
            if ai >= 0:
                isum += int(a[ai])
            if bi >= 0:
                isum += int(b[bi])
            if isum >= 2:
                carry = 1
                res.append(str(isum % 2))
            else:
                carry = 0
                res.append(str(isum))
        if carry == 1:
            res.append("1")
        return ''.join(res)[::-1];