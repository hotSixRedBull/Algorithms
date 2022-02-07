public class Solution {
    public char findTheDifference(String s, String t) {
        /*
        1. s==null,t==null
        2. Arrays.sort(s),(t)
        3. abcd,abcde / aaaa,baaaa / aaaa,abaaa
        */
        char[] s1 = s.toCharArray(),s2=t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        for(int i=0;i<s1.length;i++){
            if(s1[i]!=s2[i]){
                   return s2[i];
            }
        }
            return s2[s2.length-1];
        
    }
}