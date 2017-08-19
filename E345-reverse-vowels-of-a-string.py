class Solution(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        vowels = ['a', 'o', 'i', 'e', 'u', 'A', 'O', 'I', 'E', 'U']
        l, h = 0, len(s) - 1
        ss = list(s)
        while l < h:
            while ss[l] not in vowels and l < h:
                l += 1
            while ss[h] not in vowels and l < h:
                h -= 1
            ss[l], ss[h] = ss[h], ss[l]
            l += 1
            h -= 1
        return ''.join(ss)