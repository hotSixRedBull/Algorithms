//saw solution
//there's so many cases that i cannot handle
class Solution {

    public int regionsBySlashes(String[] grid) {
        int gridSize = grid.length;
        int pointsPerSide = gridSize + 1;
        int totalPoints = pointsPerSide * pointsPerSide;

        // Initialize disjoint set data structure
        int[] parentArray = new int[totalPoints];
        Arrays.fill(parentArray, -1);

        // Connect border points
        for (int i = 0; i < pointsPerSide; i++) {
            for (int j = 0; j < pointsPerSide; j++) {
                if (
                    i == 0 ||
                    j == 0 ||
                    i == pointsPerSide - 1 ||
                    j == pointsPerSide - 1
                ) {
                    int point = i * pointsPerSide + j;
                    parentArray[point] = 0;
                }
            }
        }

        // Set the parent of the top-left corner to itself
        parentArray[0] = -1;
        int regionCount = 1; // Start with one region (the border)

        // Process each cell in the grid
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                // Treat each slash as an edge connecting two points
                if (grid[i].charAt(j) == '/') {
                    int topRight = i * pointsPerSide + (j + 1);
                    int bottomLeft = (i + 1) * pointsPerSide + j;
                    regionCount += union(parentArray, topRight, bottomLeft);
                } else if (grid[i].charAt(j) == '\\') {
                    int topLeft = i * pointsPerSide + j;
                    int bottomRight = (i + 1) * pointsPerSide + (j + 1);
                    regionCount += union(parentArray, topLeft, bottomRight);
                }
            }
        }

        return regionCount;
    }

    // Find the parent of a set
    private int find(int[] parentArray, int node) {
        if (parentArray[node] == -1) return node;

        return parentArray[node] = find(parentArray, parentArray[node]);
    }

    // Union two sets and return 1 if a new region is formed, 0 otherwise
    private int union(int[] parentArray, int node1, int node2) {
        int parent1 = find(parentArray, node1);
        int parent2 = find(parentArray, node2);

        if (parent1 == parent2) {
            return 1; // Nodes are already in the same set, new region formed
        }

        parentArray[parent2] = parent1; // Union the sets
        return 0; // No new region formed
    }
}
/*
class Solution {
    public int regionsBySlashes(String[] grid) {
        return -1;
    }
}

/*
[" /\\ ", "//\\\\", "\\\\//", " \\/ "]
[" /  ", "/   ", "   /", "  / "]
[" / /", "/ / ", " / /", "/ / "]

6
3
4

6의 예제가 시사하는 바는, 꼭 모서리에 다 닫지 않아도 region이 나뉜다는 것.
--> 그것은 꼭 마름모의 형태를 띈다는 것
*/