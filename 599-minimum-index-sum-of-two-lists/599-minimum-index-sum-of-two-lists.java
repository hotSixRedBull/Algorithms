class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> indexMap = new HashMap();
        for (int i=0; i<list1.length; i++) {
            indexMap.put(list1[i], i);
        }
        
        int min = list1.length+list2.length;
        List<String> answers = new ArrayList();
        for (int i=0; i<list2.length; i++) {
            if (indexMap.containsKey(list2[i])) {
                int indexSum = Math.abs(i+indexMap.get(list2[i]));
                if (min > indexSum) {
                    min = indexSum;
                    answers.clear();
                    answers.add(list2[i]);
                }
                else if (min == indexSum) {
                    answers.add(list2[i]);
                }
            }
        }
        
        return answers.stream().toArray(String[]::new);
    }
}