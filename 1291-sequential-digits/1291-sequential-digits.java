class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        int cur = low;
        while (cur <= high) {
            String curToStr = Integer.toString(cur);
            int digit = Character.getNumericValue(curToStr.charAt(0));
            int size = curToStr.length();
            if (digit == 9) {
                digit = 1;
                size++;
                // System.out.println("expand size to "+size);
            }
            cur = (digit+1)*(int)Math.pow(10, size-1);
            // System.out.println("cur: "+cur);
            
            int built = 0;
            if (digit <= 10-size) {
                for (int i=0; i<size; i++) {
                    built *= 10;
                    built += digit;
                    digit++;
                }
                // System.out.println("built: "+built);
                if (built >= low && built <= high) {
                    ans.add(built);
                }
            }
        }
        return ans;
    }
}