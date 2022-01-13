class Solution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> needMap = new HashMap<>();
        HashMap<Integer, Integer> haveMap = new HashMap<>();
        for (int pay: bills) {
            haveMap.put(pay, haveMap.getOrDefault(pay, 0)+1);
            needMap.put(pay-5, needMap.getOrDefault(pay-5, 0)+1);
            if (pay == 20) {
                if (haveMap.getOrDefault(10, 0) > 0 && haveMap.getOrDefault(5, 0) > 0) {
                    haveMap.put(10, haveMap.getOrDefault(10, 0)-1);
                    haveMap.put(5, haveMap.getOrDefault(5, 0)-1);
                }
                else if (haveMap.getOrDefault(5, 0) > 2) {
                    haveMap.put(5, haveMap.getOrDefault(5, 0)-3);
                }
                else {
                    return false;
                }
                
            }
            else if (pay == 10) {
                if (haveMap.getOrDefault(5, 0) > 0) {
                    haveMap.put(5, haveMap.getOrDefault(5, 0)-1);
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}