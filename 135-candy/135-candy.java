class Solution {
    public int candy(int[] ratings) {
        int[] assign = new int[ratings.length];
        assign[0] = 1;
        if (ratings.length > 1
           && ratings[0] > ratings[1]) {
            assign[0] = 2;
        }
        for (int i=1; i<ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                assign[i] = assign[i-1]+1;
            }
            else {
                assign[i] = 1;
            }
        }
        
        int[] assign2 = new int[ratings.length];
        int l = 0;
        int r = ratings.length-1;
        while (l < r) {
            int tmp = ratings[l];
            ratings[l] = ratings[r];
            ratings[r] = tmp;
            l++;
            r--;
        }
        assign2[0] = 1;
        if (ratings.length > 1
           && ratings[0] > ratings[1]) {
            assign2[0] = 2;
        }
        for (int i=1; i<ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                assign2[i] = assign2[i-1]+1;
            }
            else {
                assign2[i] = 1;
            }
        }
        
        int sum = 0;
        for (int i=0; i<ratings.length; i++) {
            sum += Math.max(assign[i], assign2[ratings.length-1-i]);
        }
        return sum;
    }
}

/*
terrible part is when i need to change previous values.

[0,0,0,0,0] -> 5
[1,1,1,1,1] -> 5
[1,2,3,4,5] -> 15
[1,2,1,2,1] -> 7
[2,1,2,1,2] -> 8
[1,0,1,0,1] -> 8
[1,2,3,1,2,3] -> 12

[0,0,0,0,0]
[1,1,1,1,1]
[1,2,3,4,5]
[1,2,1,2,1]
[2,1,2,1,2]
[1,0,1,0,1]
[1,2,3,1,2,3]
[1,3,2,2,1]
[1,3,2,1]

failed
[1,2,87,87,87,2,1]
*/