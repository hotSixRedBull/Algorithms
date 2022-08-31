//solution used
//actually solution didn't work, so i used code in discuss section
class Solution {
    public int poorPigs(int buckets, int tdie, int ttest) {
        int test = ttest/tdie;
        int i=0;
        while(Math.pow(test+1,i)< buckets){
            i++;
        }return i;
    }
}