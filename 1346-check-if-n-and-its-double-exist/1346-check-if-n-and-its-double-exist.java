class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer, Boolean> existMap = new HashMap();
        for (int num : arr) {
            int div = num/2;
            int mul = num*2;
            if ((num % 2 == 0 && existMap.containsKey(div)) 
                || existMap.containsKey(mul)) {
                return true;
            }
            existMap.put(num, true);
        }
        return false;
    }
}