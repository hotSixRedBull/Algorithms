//saw solution
class Solution {

    // Convert to palindrome keeping first half constant.
    private long convert(long num) {
        String s = Long.toString(num);
        int n = s.length();
        int l = (n - 1) / 2, r = n / 2;
        char[] sArray = s.toCharArray();
        while (l >= 0) {
            sArray[r++] = sArray[l--];
        }
        return Long.parseLong(new String(sArray));
    }

    // Find the next palindrome, just greater than n.
    private long nextPalindrome(long num) {
        long left = 0, right = num;
        long ans = Long.MIN_VALUE;
        while (left <= right) {
            long mid = (right - left) / 2 + left;
            long palin = convert(mid);
            if (palin < num) {
                ans = palin;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // Find the previous palindrome, just smaller than n.
    private long previousPalindrome(long num) {
        long left = num, right = (long) 1e18;
        long ans = Long.MIN_VALUE;
        while (left <= right) {
            long mid = (right - left) / 2 + left;
            long palin = convert(mid);
            if (palin > num) {
                ans = palin;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        long a = nextPalindrome(num);
        long b = previousPalindrome(num);
        if (Math.abs(a - num) <= Math.abs(b - num)) {
            return Long.toString(a);
        }
        return Long.toString(b);
    }
}
/*
import java.math.BigInteger;
 
class Solution {
    public String nearestPalindromic(String n) {
        String h = hueristic(n);
        int len = n.length();
        StringBuilder smaller = new StringBuilder();
        for (int i=0; i<len-1; i++) {
            smaller.append('9');
        }
        if (smaller.length() == 0) {
            smaller.append('0');
        }
        StringBuilder bigger = new StringBuilder();
        for (int i=0; i<=len; i++) {
            bigger.append('1');
        }
        BigInteger bi1 = new BigInteger(h);
        BigInteger bi2 = new BigInteger(smaller.toString());
        BigInteger bi3 = new BigInteger(bigger.toString());
        BigInteger bi4 = new BigInteger(n);
        bi1 = bi4.subtract(bi1);
        bi2 = bi4.subtract(bi2);
        bi3 = bi3.subtract(bi4);
        System.out.println(String.format("bi1: %s, bi2: %s, bi3: %s",bi1,bi2,bi3));
        if (bi1.abs().compareTo(bi2.abs()) == -1) {
            if (bi1.abs().compareTo(bi3.abs()) == -1) {
                return h;
            }
            else if (bi1.abs().compareTo(bi3.abs()) == 1) {
                return bigger.toString();
            }
            else {
                BigInteger bi5 = new BigInteger(h);
                BigInteger bi6 = new BigInteger(bigger.toString());
                return bi5.min(bi6).toString();
            }
        }
        else if (bi1.abs().compareTo(bi2.abs()) == 1) {
            if (bi2.abs().compareTo(bi3.abs()) == -1) {
                return smaller.toString();
            }
            else if (bi2.abs().compareTo(bi3.abs()) == 1){
                return bigger.toString();
            }
            else {
                BigInteger bi5 = new BigInteger(smaller.toString());
                BigInteger bi6 = new BigInteger(bigger.toString());
                return bi5.min(bi6).toString();
            }
        }
        else {
            if (bi2.abs().compareTo(bi3.abs()) == -1) {
                //bi1, bi2
                BigInteger bi5 = new BigInteger(h);
                BigInteger bi6 = new BigInteger(smaller.toString());
                return bi5.min(bi6).toString();
            }
            else if (bi2.abs().compareTo(bi3.abs()) == 1){
                return bigger.toString();
            }
            else {
                BigInteger bi5 = new BigInteger(smaller.toString());
                BigInteger bi6 = new BigInteger(bigger.toString());
                BigInteger bi7 = new BigInteger(h);
                return bi5.min(bi6.min(bi7)).toString();
            }
        }
    }
    public String hueristic(String n) {
        if (isPal(n)) {
            int mid = (int)Math.floor(n.length()/2);
            // System.out.println(String.format("1, mid: %d",mid));
            if (n.length()%2 == 1) {
                StringBuilder sb = new StringBuilder();
                for (int i=0; i<mid; i++) {
                    sb.append(n.charAt(i));
                }
                int val = n.charAt(mid)-'0';
                if (val == 0) {
                    val = 1;
                }
                else {
                    val--;
                }
                // System.out.println(String.format("1, val: %d",val));
                sb.append((char)(val+'0'));
                for (int i=mid+1; i<n.length(); i++) {
                    sb.append(n.charAt(i));
                }
                return sb.toString();
            }
            else {
                mid--;
                StringBuilder sb = new StringBuilder();
                for (int i=0; i<mid; i++) {
                    sb.append(n.charAt(i));
                }
                int val = n.charAt(mid)-'0';
                if (val == 0) {
                    val = 1;
                }
                else if (mid == 0
                        && val == 1) {
                    val = 2;
                }
                else {
                    val--;
                }
                sb.append((char)(val+'0'));
                sb.append((char)(val+'0'));
                for (int i=mid+2; i<n.length(); i++) {
                    sb.append(n.charAt(i));
                }
                return sb.toString();
            }
        }
        else {
            // System.out.println("2");
            StringBuilder sb = new StringBuilder();
            Stack<Character> stk = new Stack();
            int mid = (int)Math.floor(n.length()/2);
            for (int i=0; i<mid; i++) {
                sb.append(n.charAt(i));
                stk.push(n.charAt(i));
            }
            if (n.length() % 2 == 1) {
                sb.append(n.charAt((n.length()-1)/2));
            }
            while (stk.size() > 0) {
                sb.append(stk.pop());
            }
            return sb.toString();
        }
    }
    public boolean isPal(String n) {
        int left=0;
        int right=n.length()-1;
        while (left < right) {
            if (n.charAt(left) != n.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

/*

18digit ==> 10^17 ==> (2^10)^5*10^2
if n is palindrome:
    find next palindrome with changing +-1 to each slot
else:
    make n to palindrome as copying left side to right side

"8"
"123"
"1223"
"1"
"11"
*/