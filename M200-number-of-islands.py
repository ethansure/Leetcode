class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid:
            return 0
        islands = 0
        x = 0
        while x < len(grid):
            y = 0
            while y < len(grid[0]):
                if grid[x][y] == '1':
                    islands += 1
                    self.submerge(grid, x, y)
                y += 1
            x += 1
        return islands
    def submerge(self, grid, x, y):
        grid[x][y] = '0'
        if x + 1 < len(grid) and grid[x + 1][y] == '1':
            self.submerge(grid, x + 1, y)
        if y + 1 < len(grid[0]) and grid[x][y + 1] == '1':
            self.submerge(grid, x, y + 1)
        if x - 1 >= 0  and grid[x - 1][y] == '1':
            self.submerge(grid, x - 1, y)
        if y - 1 >= 0  and grid[x][y - 1] == '1':
            self.submerge(grid, x, y - 1)