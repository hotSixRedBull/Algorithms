class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap();
        int max = 0;
        int start=0;
        for (int i=0; i<fruits.length; i++) {
            int fruit = fruits[i];
            if (map.containsKey(fruit) == false
               && map.size() == 2) {
                while(map.size() == 2
                     && start < i) {
                    if (map.get(fruits[start]) == 1) {
                        map.remove(fruits[start++]);
                        break;
                    }
                    map.put(fruits[start], map.get(fruits[start])-1);
                    start++;
                }
            }
            map.put(fruit, map.getOrDefault(fruit, 0)+1);
            max = Math.max(max, i-start+1);
        }
        return max;
    }
}