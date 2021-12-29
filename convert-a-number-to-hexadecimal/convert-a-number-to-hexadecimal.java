class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        String answer = "";
        char[] hex = {'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            //System.out.println(num);
            int calc = num&15;
            if (calc > 9) {
                sb.append(hex[calc-10]);
            }
            else {
                sb.append(Integer.toString(calc));    
            }
            num = num >>> 4;
        }
        answer = sb.reverse().toString();
        return answer;
    }
}