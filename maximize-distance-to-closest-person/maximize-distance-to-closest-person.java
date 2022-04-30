class Solution {
    public int maxDistToClosest(int[] seats) {
        int i = 0;
        //left end
        while (i < seats.length
               && seats[i] == 0) {
            i++;
        }
        int leftDistance = i;
        
        //middle part
        int middleDistance = 0;
        int contiguous = 0;
        for (int pos=i; pos<seats.length; pos++) {
            if (seats[pos] == 0) {
                contiguous++;
                middleDistance = Math.max(middleDistance, (contiguous+1)/2);
            }
            else {
                contiguous = 0;
            }
        }
        
        //right end
        int endIndex = seats.length-1;
        while (endIndex >= 0 
               && seats[endIndex] == 0) {
            endIndex--;
        }
        int rightDistance = seats.length-1-endIndex;
        
        return Math.max(leftDistance, Math.max(middleDistance, rightDistance));
    }
}