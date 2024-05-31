//saw solution
//couldn't solve some cases
public class Solution {

    public String kthLuckyNumber(int k) {
        int c = 0; // The number of digits in the kth lucky number
        int numCount = 0; // The number of lucky numbers with c or fewer digits
        while (numCount < k) {
            c++;
            numCount += Math.pow(2, c);
        }

        // Calculate the number of lucky numbers with c digits before the kth
        // lucky number
        int x = k - 1 - (int) (numCount - Math.pow(2, c));

        // Build result using x by prepending 4 for 0 and 1 for 7
        StringBuilder kthLuckyNum = new StringBuilder();
        for (int i = 0; i < c; i++) {
            char digit;
            if (x % 2 == 1) {
                digit = '7';
            } else {
                digit = '4';
            }
            kthLuckyNum.insert(0, digit);
            x /= 2;
        }

        return kthLuckyNum.toString();
    }
}

/*
class Solution {
    public String kthLuckyNumber(int k) {
        if (k == 1) {
            return "4";
        }
        String ans = "";
        int digit = getDigit(k);
        int left = sum(digit-1);
        int right = sum(digit);
        int right_initial = right;
        System.out.println(String.format("k: %d, digit: %d, left: %d, right: %d", k, digit, left, right));
        while (left <= right) {
            if (ans.length() == digit) {
                break;
            }
            int mid = (left+right+1)/2;
            System.out.println(String.format("mid: %d", mid));
            if (k <= mid && k != right_initial) {
                ans = ans + "4";
                right = mid-1;
            }
            else {
                ans = ans + "7";
                left = mid+1;
            }
        }
        return ans;
    }
    
    public int getDigit(int k) {
        for (int i=0; i<33; i++) {
            if (k <= sum(i)) {
                return i;
            }
        }
        return -1;
    }
    
    public int sum(int digit) {
        return 2*((int)Math.pow(2, digit)-1);
    }
}

/*
digit = log2N
*/