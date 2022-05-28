class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int compared = 0;
        for (int i=1; i<=Math.sqrt(num); i++) {
            if (num % i == 0) {
                compared += i;
                if (i != num/i
                   && i != 1) {
                    compared += num/i;
                }
                // System.out.println(compared);
            }
        }
        System.out.println(compared);
        return compared == num;
    }
}