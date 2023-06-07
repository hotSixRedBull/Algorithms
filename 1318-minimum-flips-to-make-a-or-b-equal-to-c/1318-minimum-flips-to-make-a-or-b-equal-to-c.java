class Solution {
    public int minFlips(int a, int b, int c) {
        int need = 0;
        for (int i=0; i<32; i++) {
            boolean abit = ((a >> i) & 1) == 1;
            boolean bbit = ((b >> i) & 1) == 1;
            boolean cbit = ((c >> i) & 1) == 1;
            if (cbit) {
                if (abit || bbit) {
                    continue;
                }
                need++;
            }
            else {
                if (abit) {
                    need++;
                }
                if (bbit) {
                    need++;
                }
            }
        }
        return need;
    }
}