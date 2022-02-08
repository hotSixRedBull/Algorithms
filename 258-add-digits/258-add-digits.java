public class Solution {
    public int addDigits(int num) {
        if(num == 0) return 0;
        int sum = 0;
        String s = String.valueOf(num);
        for(char c : s.toCharArray()){
           // System.out.println("c :"+c);
            sum += Integer.parseInt(String.valueOf(c));
       // System.out.println(sum);
        }
        while(sum%10 != sum){
            s = new String(String.valueOf(sum));
            sum = 0;
            for(char c : s.toCharArray()){
                sum += Integer.parseInt(String.valueOf(c));
            }
        }
        return sum;
    }
}