class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        lines = []
        for i in range(0,numRows):
            line = i + 1
            items = []
            for itemi in range(0,line):
                if itemi == 0 or itemi == line - 1:
                    items.append(1)
                else:
                    preLine = lines[i - 1]
                    items.append(preLine[itemi - 1] + preLine[itemi])
            lines.append(items)
        return lines