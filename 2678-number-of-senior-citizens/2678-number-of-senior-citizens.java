class Solution {
    public int countSeniors(String[] details) {
        int cnt = 0;
        for (String d : details) {
            int age = Integer.parseInt(d.substring(11,13),10);
            // System.out.println(age);
            if (age > 60) {
                cnt++;
            }
        }
        return cnt;
    }
}