class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drank = 0;
        int emptyBottles = 0;
        while (numBottles != 0) {
            //System.out.println(String.format("numBottles: %d, emptyBottles: %d, drank: %d", numBottles, emptyBottles, drank));
            drank += numBottles;
            int nextEmptyBottles = (numBottles+emptyBottles)%numExchange;
            numBottles = (numBottles+emptyBottles)/numExchange;
            emptyBottles = nextEmptyBottles;
        }
        return drank;
    }
}