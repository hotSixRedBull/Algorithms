class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int index = 0;
        int last = 0;
        for (; index<bits.length; index++) {
            last = index;
            if (bits[index] == 1) {
                index++;
            }
        }
        
        return last == bits.length-1;
    }
}