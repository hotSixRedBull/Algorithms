class Solution {
    public int[] findEvenNumbers(int[] digits) {
        List<Integer> list = new ArrayList();
        int[] arr = new int[10];
        for (int num : digits) {
            arr[num]++;
        }
        for (int num = 100; num <= 999; num+=2) {
            int numCpy = num;
            int a = numCpy%10;
            numCpy /= 10;
            int b = numCpy%10;
            numCpy /= 10;
            int c = numCpy%10;
            
            arr[a]--;
            arr[b]--;
            arr[c]--;
            
            if (arr[a] >= 0 && arr[b] >= 0 && arr[c] >= 0) {
                list.add(num);
            } 
            
            arr[a]++;
            arr[b]++;
            arr[c]++;
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}