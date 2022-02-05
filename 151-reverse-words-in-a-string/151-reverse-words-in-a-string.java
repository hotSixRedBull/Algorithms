class Solution {
    public String reverseWords(String s) {
        s = s.replaceAll("[ ]+", " ");
        s = s.strip();
        String[] splited = s.split(" ");
        for (int i=0; i<splited.length/2; i++) {
            int target = splited.length-1-i;
            String tmp = splited[i];
            splited[i] = splited[target];
            splited[target] = tmp;
        }
        return String.join(" ", splited);
    }
}