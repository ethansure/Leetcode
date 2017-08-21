class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        l = ['(','{','[']
        r = [')','}',']']
        stack = []
        for i in s:
            if i in l or len(stack) == 0:
                stack.append(i)
            elif i in r and len(stack) != 0:
                if stack[-1] + i in ('()', '{}', '[]'):
                    stack.pop()
                else:
                    stack.append(i)
        return len(stack) == 0