// saw solution
// coudn't handle same priority values
class Solution {

    public int[][] buildMatrix(
        int k,
        int[][] rowConditions,
        int[][] colConditions
    ) {
        // Store the topologically sorted sequences.
        List<Integer> orderRows = topoSort(rowConditions, k);
        List<Integer> orderColumns = topoSort(colConditions, k);

        // If no topological sort exists, return empty array.
        if (orderRows.isEmpty() || orderColumns.isEmpty()) return new int[0][0];

        int[][] matrix = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (orderRows.get(i).equals(orderColumns.get(j))) {
                    matrix[i][j] = orderRows.get(i);
                }
            }
        }
        return matrix;
    }

    private List<Integer> topoSort(int[][] edges, int n) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        List<Integer> order = new ArrayList<>();
        // 0: not visited, 1: visiting, 2: visited
        int[] visited = new int[n + 1];
        boolean[] hasCycle = { false };

        // Perform DFS for each node
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                dfs(i, adj, visited, order, hasCycle);
                // Return empty if cycle detected
                if (hasCycle[0]) return new ArrayList<>();
            }
        }

        // Reverse to get the correct order
        Collections.reverse(order);
        return order;
    }

    private void dfs(
        int node,
        List<List<Integer>> adj,
        int[] visited,
        List<Integer> order,
        boolean[] hasCycle
    ) {
        visited[node] = 1; // Mark node as visiting
        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 0) {
                dfs(neighbor, adj, visited, order, hasCycle);
                // Early exit if a cycle is detected
                if (hasCycle[0]) return;
            } else if (visited[neighbor] == 1) {
                // Cycle detected
                hasCycle[0] = true;
                return;
            }
        }
        // Mark node as visited
        visited[node] = 2;
        // Add node to the order
        order.add(node);
    }
}
/*
class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int v) {
        val = v;
        next = null;
    }
}

class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] ans = new int[k][k];
        int[][] rc = new int[k][2]; //[r,c]
        int[] inDegreeR = new int[k];
        ListNode[] rNodes = new ListNode[k];
        int[] inDegreeC = new int[k];
        ListNode[] cNodes = new ListNode[k];
        for (int i=0; i<k; i++) {
            rNodes[i] = new ListNode(i+1);
            cNodes[i] = new ListNode(i+1);
        }
        for (int[] condition : rowConditions) {
            int above = condition[0];
            int below = condition[1];
            rNodes[above-1].next = rNodes[below-1];
            inDegreeR[below-1]++;
        }
        for (int[] condition : colConditions) {
            int left = condition[0];
            int right = condition[1];
            cNodes[left-1].next = cNodes[right-1];
            inDegreeC[right-1]++;
        }
        Queue<Integer> rq = new ArrayDeque();
        for (int i=0; i<k; i++) {
            if (inDegreeR[i] == 0) {
                rq.add(i);
            }
        }
        if (rq.size() == 0) {
            return new int[0][0];
        }
        //tortoise and hare를 넣어야하나?
        int rowLevel = 0;
        while (rq.size() > 0) {
            if (rowLevel >= k) {
                return new int[0][0];
            }
            Queue<Integer> newrq = new ArrayDeque();
            for (int node : rq) {
                rc[node][0] = rowLevel;
                if (rNodes[node].next != null) {
                    newrq.add(rNodes[node].next.val-1);
                }
            }
            rq = newrq;
            rowLevel++;
        }
        Queue<Integer> cq = new ArrayDeque();
        for (int i=0; i<k; i++) {
            if (inDegreeC[i] == 0) {
                cq.add(i);
            }
        }
        if (cq.size() == 0) {
            return new int[0][0];
        }
        //tortoise and hare를 넣어야하나?
        int colLevel = 0;
        while (cq.size() > 0) {
            if (colLevel >= k) {
                return new int[0][0];
            }
            Queue<Integer> newcq = new ArrayDeque();
            for (int node : cq) {
                rc[node][1] = colLevel;
                if (cNodes[node].next != null) {
                    newcq.add(cNodes[node].next.val-1);
                }
            }
            cq = newcq;
            colLevel++;
        }
        
        for (int i=0; i<k; i++) {
            // System.out.println(Arrays.toString(rc[i]));
            ans[rc[i][0]][rc[i][1]] = i+1;
        }
        return ans;
    }
}

/*

cycle(invalid)를 알아낼 방법.
1. unionFind? 같은 쌍이 있을 수도 있다.
2. tortoise and hare

graph형식으로 표기하면 어떨까.
1->2
3->2

*/