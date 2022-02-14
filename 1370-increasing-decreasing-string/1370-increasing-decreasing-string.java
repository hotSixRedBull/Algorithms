class Solution {
    public String sortString(String s) {
        HashMap<Character, Integer> freqMap = new HashMap();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        String result = "";
        while (freqMap.size() > 0) {
            Set<Character> forArr = freqMap.keySet();
            Character[] arr = forArr.toArray(new Character[0]);
            Arrays.sort(arr);
            //System.out.println(Arrays.toString(arr));
            for (int i=0; i<arr.length; i++) {
                result += arr[i];
                int stored = freqMap.getOrDefault(arr[i], 0);
                if (stored == 1) {
                    freqMap.remove(arr[i]);
                }
                else {
                    freqMap.put(arr[i], stored - 1);
                }
            }
            for (int i=arr.length-1; i>=0; i--) {
                int stored = freqMap.getOrDefault(arr[i], 0);
                if (stored != 0) {
                    result += arr[i];
                    if (stored == 1) {
                        freqMap.remove(arr[i]);
                    }
                    else {
                        freqMap.put(arr[i], stored - 1);
                    }  
                }
            }
        }
        return result;
    }
}