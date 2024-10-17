//skip
//late work
class Solution {

    public int maximumSwap(int num) {
        char[] numStr = Integer.toString(num).toCharArray();
        int n = numStr.length;
        int maxDigitIndex = -1, swapIdx1 = -1, swapIdx2 = -1;

        // Traverse the string from right to left, tracking the max digit and
        // potential swap
        for (int i = n - 1; i >= 0; --i) {
            if (maxDigitIndex == -1 || numStr[i] > numStr[maxDigitIndex]) {
                maxDigitIndex = i; // Update the index of the max digit
            } else if (numStr[i] < numStr[maxDigitIndex]) {
                swapIdx1 = i; // Mark the smaller digit for swapping
                swapIdx2 = maxDigitIndex; // Mark the larger digit for swapping
            }
        }

        // Perform the swap if a valid swap is found
        if (swapIdx1 != -1 && swapIdx2 != -1) {
            char temp = numStr[swapIdx1];
            numStr[swapIdx1] = numStr[swapIdx2];
            numStr[swapIdx2] = temp;
        }

        return Integer.parseInt(new String(numStr)); // Return the new number or the original if no
        // swap occurred
    }
}
/*
class Solution {
    public int maximumSwap(int num) {
        List<Integer> li = new ArrayList();
        int tmp = num;
        while(tmp > 0) {
            int last = tmp % 10;
            tmp = tmp / 10;
            li.add(last);
        }
        Collections.sort(li);
        String str = Integer.toString(num);
        for (int i=0; i<li.size(); i++) {
            int num = (int)(str.charAt(i)-'0');
            if (num != li.get(i)) {
                for (int j=li.size(); j>=0; j--) {
                    if (li.get(i)+'0' == )
                }
            }
        }
        return num;
    }
}
*/