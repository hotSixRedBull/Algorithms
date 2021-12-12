class Solution {
    class Pair<T,U> {
        private T f;
        private U s;
        public Pair() {}
        public Pair(T first, U second) {
            this.f = first;
            this.s = second;
        }
        public void setF(T first) {
            this.f = first;
        }
        public void sets(U second) {
            this.s = second;
        }
        public T getF() {
            return this.f;
        }
        public U getS() {
            return this.s;
        }
    }
    public int orangesRotting(int[][] grid) {
        //count oranges and make a linked list
        LinkedList<Pair<Integer, Integer>> oranges = new LinkedList<Pair<Integer, Integer>>();
        for (int r=0; r<grid.length; r++) {
            for (int c=0; c<grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    oranges.add(new Pair(r,c));
                }
            }
        }
        
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int answer = 0;
        while (oranges.size() > 0) {
            //System.out.println("Before: "+oranges);
            int thisRoundCnt = oranges.size();
            LinkedList<Pair<Integer, Integer>> toBeDeleted = new LinkedList<Pair<Integer, Integer>>();
            
            Iterator<Pair<Integer, Integer>> iterator = oranges.iterator();
            while (iterator.hasNext()) {
                Pair<Integer, Integer> current = iterator.next();
                for (int i=0; i<4; i++) {
                    int targetR = dr[i] + current.getF();
                    int targetC = dc[i] + current.getS();
                    if (targetR > -1 && targetR < grid.length && targetC > -1 && targetC < grid[0].length) {
                        if (grid[targetR][targetC] == 2) {
                            toBeDeleted.add(current);
                            break;
                        }
                    }
                }
            }
            //System.out.println("toBeDeleted: "+toBeDeleted);
            
            iterator = toBeDeleted.iterator();
            while (iterator.hasNext()) {
                Pair<Integer, Integer> current = iterator.next();
                grid[current.getF()][current.getS()] = 2;
                oranges.remove(current);
            }
            //System.out.println("After: "+oranges);
            answer++;
            if (oranges.size() == thisRoundCnt) {
                return -1;
            }
        }
        return answer;
    }
}