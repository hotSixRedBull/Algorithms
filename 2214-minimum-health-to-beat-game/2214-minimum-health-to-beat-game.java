class Solution {
    public long minimumHealth(int[] damage, int armor) {
        boolean armorUsed = false;
        long max = -1;
        long sum = 0;
        for (int d : damage) {
            sum += d;
            if (!armorUsed) {
                if (d >= armor) {
                    sum -= armor;
                    armorUsed = true;
                }
                else if (d <= armor) {
                    max = Math.max(max, d);
                }
            }
        }
        if (armorUsed) {
            return sum + 1;
        }
        else {
            return sum - max + 1;
        }
    }
}

/*
[0,4,3,0,0]
1
- didn't think about 0 damage
[1,5,0,0,5]
3
*/