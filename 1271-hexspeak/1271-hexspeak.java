import java.math.BigInteger;
class Solution {
    public String toHexspeak(String num) {
        HashMap<Character, Character> map = new HashMap();
        for (char c = 'A'; c < 'G'; c++) {
            map.put(c, c);
        }
        map.put('1', 'I');
        map.put('0', 'O');
        BigInteger bi = new BigInteger(num);
        String converted = bi.toString(16).toUpperCase();
        // System.out.println("converted: "+converted);
        StringBuilder ans = new StringBuilder();
        for (char c : converted.toCharArray()) {
            if (map.containsKey(c)) {
                ans.append(map.get(c));
            }
            else {
                return "ERROR";
            }
        }
        return ans.toString();
    }
}
/*
"747823223228"
"619879596177"
*/