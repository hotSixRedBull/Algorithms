class Solution {
    Map<Integer, Boolean> cache;
    
    public Solution() {
        cache = new HashMap();
    }
    
    public boolean nimGame(int[] piles) {
        // System.out.println(Arrays.toString(piles));
        int key = pilesToNumber(piles);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int positivePile = 0;
        int maxStone = 0;
        for (int p : piles) {
            if (p > 0) {
                positivePile++;
                maxStone += p;
            }
        }
        if (positivePile == 1) {
            return true;
        }
        else if (maxStone == 1) {
            return positivePile % 2 == 1;
        }
        else {
            for (int i=0; i<piles.length; i++) {
                int tmp = piles[i];
                for (int stone=0; stone<piles[i]; stone++) {
                    piles[i] = stone;
                    if (!nimGame(piles)) {   
                        piles[i] = tmp;                     
                        // System.out.println(String.format("If piles: %s, pile[%d]: %d, won", Arrays.toString(piles), i, stone));
                        cache.put(key, true);
                        return true;
                    }
                    piles[i] = tmp;
                }
            }             
            // System.out.println(String.format("If piles: %s, whatever i do, lost", Arrays.toString(piles)));
            cache.put(key, false);
            return false;
        }
    }
    
    public int pilesToNumber(int[] p) {
        int ret = 0;
        for (int i=0; i<p.length; i++) {
            ret += p[i];
            ret *= 8;
        }
        return ret;
    }
}

/*
[7,7,7,7,7,7,7]
*/