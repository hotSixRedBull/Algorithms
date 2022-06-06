class Solution {
    public String reverseWords(String s) {
        String[] splitted = s.split(" ");
        for (int i=0; i<splitted.length; i++) {
            int left = 0;
            int right = splitted[i].length()-1;
            char[] arr = splitted[i].toCharArray();
            while (left <= right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            splitted[i] = new String(arr);
        }
        
        return String.join(" ", splitted);
    }
}