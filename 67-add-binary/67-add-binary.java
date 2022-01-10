class Solution {
    public String addBinary(String a, String b) {
        int aPos = a.length()-1;
        int bPos = b.length()-1;
        String answer = "";
        int carry = 0;
        while (aPos >= 0 && bPos >= 0) {
            int cur = Character.getNumericValue(a.charAt(aPos))+Character.getNumericValue(b.charAt(bPos)) + carry;
            if (cur >= 2) {
                carry = 1;
                cur -= 2;
            }
            else {
                carry = 0;
            }
            answer = Integer.toString(cur) + answer;
            aPos--;
            bPos--;
        }
        //System.out.println(answer);
        while (carry == 1) {
            if (aPos >= 0) {
                int cur = Character.getNumericValue(a.charAt(aPos))+carry;
                if (cur < 2) {
                    carry = 0;
                }
                else {
                    cur -= 2;
                }
                answer = Integer.toString(cur) + answer;
                aPos--;
            }
            else if (bPos >= 0) {
                int cur = Character.getNumericValue(b.charAt(bPos))+carry;
                if (cur < 2) {
                    carry = 0;
                }
                else {
                    cur -= 2;
                }
                answer = Integer.toString(cur) + answer;
                bPos--;
            }
            else {
                answer = "1" + answer;
                carry = 0;
            }
        }
        //System.out.println(answer);
        if (aPos >= 0) {
            answer = a.substring(0, aPos+1) + answer;  
        }
        if (bPos >= 0) {
            answer = b.substring(0, bPos+1) + answer;
        }
        return answer;
    }
}