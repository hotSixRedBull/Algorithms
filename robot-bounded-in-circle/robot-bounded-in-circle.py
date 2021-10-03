class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        dr = [-1,0,1,0]
        dc = [0,1,0,-1]
        index = 0
        dx = 0
        dy = 0
        for i in range(0,4):
            for char in instructions:
                if char == 'G':
                    dx = dx + dr[index]
                    dy = dy + dc[index]
                if char == 'L':
                    index -= 1
                    if index == -1:
                        index = 3
                if char == 'R':
                    index += 1
                    if index == 4:
                        index = 0
        if dx == 0 and dy == 0:
            return True
        else:
            return False