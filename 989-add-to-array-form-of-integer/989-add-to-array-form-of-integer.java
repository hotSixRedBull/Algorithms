class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        String strK = Integer.toString(k);
        Stack<Integer> stkNum = new Stack();
        Stack<Integer> stkK= new Stack();
        
        for (int i=0; i<num.length; i++) {
            stkNum.add(num[i]);
        }
        for (int i=0; i<strK.length(); i++) {
            stkK.add(strK.charAt(i)-'0');
        }
        
        Stack<Integer> stkAns = new Stack();
        int carry = 0;
        while (stkNum.size() > 0 && stkK.size() > 0) {
            int curNum = stkNum.pop();
            int curK = stkK.pop();
            if (curNum + curK + carry >= 10) {
                stkAns.add(curNum+curK+carry-10);
                carry = 1;
            }
            else {
                stkAns.add(curNum+curK+carry);
                carry = 0;
            }
            
        }
        
        while (stkNum.size() > 0) {
            int curNum = stkNum.pop();
            if (curNum+carry >= 10) {
                stkAns.add(curNum+carry-10);
                carry = 1;
            }
            else {
                stkAns.add(curNum+carry);
                carry = 0;
            }
        }
        
        while (stkK.size() > 0) {
            int curK = stkK.pop();
            if (curK+carry >= 10) {
                stkAns.add(curK+carry-10);
                carry = 1;
            }
            else {
                stkAns.add(curK+carry);
                carry = 0;
            }
        }
        
        if (carry == 1) {
            stkAns.add(1);
            carry = 0;
        }
        
        List<Integer> ansList = new ArrayList();
        while (stkAns.size() > 0) {
            ansList.add(stkAns.pop());
        }
        
        return ansList;
    }
}