class Solution {
    public int[][] reconstructQueue(int[][] people) {
        LinkedList<int[]> li = new LinkedList();
        HashMap<Integer, PriorityQueue<int[]>> map = new HashMap();
        for (int[] p : people) {
            if (!map.containsKey(p[1])) {
                map.put(p[1], new PriorityQueue<int[]>((a, b) -> b[0]-a[0]));
            }
            map.get(p[1]).add(p);
        }
        List<Integer> sorted = new ArrayList(map.keySet());
        Collections.sort(sorted);
        for (int key : sorted) {
            PriorityQueue<int[]> cur = map.get(key);
            // System.out.println(cur.size());
            if (key == 0) {
                while (cur.size() > 0) {
                    li.add(0, cur.poll());
                }
                continue;
            }
            while (cur.size() > 0) {
                int[] min = cur.poll();
                // System.out.println(Arrays.toString(min));
                int cnt = key;
                boolean put = false;
                for (int i=0; i<li.size(); i++) {
                    if (cnt == 0) {
                        li.add(i, min);
                        put = true;
                        break;
                    }
                    if (li.get(i)[0] >= min[0]) {
                        cnt--;
                    }
                }
                if(!put) {
                    li.add(min);
                }
            }
            // for (int i=0; i<li.size(); i++) {
            //     System.out.print(Arrays.toString(li.get(i))+" ");
            // }
            // System.out.println();
        }
        int[][] answer = new int[people.length][2];
        for (int i=0; i<li.size(); i++) {
            answer[i][0] = li.get(i)[0];
            answer[i][1] = li.get(i)[1];
        }
        return answer;
    }
}

/*
[[71,16],[60,30],[26,69],[24,10],[99,0],[5,52],[88,0],[76,0],[61,18],[68,30],[90,11],[11,34],[44,10],[28,28],[68,20],[83,2],[69,11],[81,15],[6,6],[0,71],[58,22],[84,15],[50,29],[5,25],[16,50],[64,13],[39,15],[24,48],[95,8],[99,2],[36,33],[10,44],[82,10],[13,79],[81,12],[97,1],[40,3],[31,48],[66,33],[46,20],[90,1],[1,52],[42,18],[4,2],[90,3],[28,6],[62,21],[99,3],[5,48],[55,16],[30,32],[70,3],[33,49],[99,1],[82,7],[73,15],[43,1],[72,6],[59,36],[18,6],[25,16],[96,0],[8,54],[44,25],[17,10],[4,38],[37,37],[29,0],[86,5],[79,12],[52,26],[54,11],[73,22],[99,4],[24,45],[7,32],[43,23],[30,51],[13,4],[68,15],[17,11],[11,43],[38,3],[63,28],[48,18],[40,28],[36,40],[22,44],[43,6],[4,9],[78,10],[94,5],[69,2],[26,39],[96,7],[22,37],[22,30],[65,17],[63,1],[20,41]]
*/