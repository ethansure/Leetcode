class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        mini = self.getMin()
        if mini == None or x < mini:
            self.stack.append((x, x))
        else:
            self.stack.append((x, mini))

    def pop(self):
        """
        :rtype: void
        """
        self.stack.pop()
    
    def top(self):
        """
        :rtype: int
        """
        if len(self.stack) > 0:
            return self.stack[-1][0]
        else:
            return None

    def getMin(self):
        """
        :rtype: int
        """
        if len(self.stack) > 0:
            return self.stack[-1][1]
        else:
            return None
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()