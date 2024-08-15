class Solution {
    
    public boolean lemonadeChange(int[] bills) {
        return hasRightChange(bills, 0, new HashMap());
    }
    
    public boolean hasRightChange(int[] bills, int cur, Map<Integer, Integer> change) {
        if (cur >= bills.length) {
            return true;
        }
        int paid = bills[cur];
        Map<Integer, Integer> newChange = new HashMap(change);
        if (paid == 20) {
            if (change.getOrDefault(5, 0) >= 3) {
                newChange.put(5, newChange.get(5)-3);
                if (change.getOrDefault(10, 0) >= 1) {
                    Map<Integer, Integer> newChange2 = new HashMap(change);
                    newChange2.put(5, newChange2.get(5)-1);
                    newChange2.put(10, newChange2.get(10)-1);
                    return hasRightChange(bills, cur+1, newChange) || hasRightChange(bills, cur+1, newChange2);
                }
                else {
                    return hasRightChange(bills, cur+1, newChange);
                }
            }
            else if (change.getOrDefault(5, 0) >= 1
                    && change.getOrDefault(10, 0) >= 1) {
                    newChange.put(5, newChange.get(5)-1);
                    newChange.put(10, newChange.get(10)-1);
                    return hasRightChange(bills, cur+1, newChange);
            }
            else {
                return false;
            }
        }
        else if (paid == 10) {
            if (change.getOrDefault(5, 0) < 1) {
                return false;
            }
            newChange.put(5, newChange.get(5)-1);
            newChange.put(10, newChange.getOrDefault(10, 0)+1);
            return hasRightChange(bills, cur+1, newChange);
        }
        else {
            newChange.put(5, newChange.getOrDefault(5, 0)+1);
            return hasRightChange(bills, cur+1, newChange);
        }
    }
}