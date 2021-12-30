class Solution {
    public String sortSentence(String s) {
        String[] splited = s.split(" ");
        String[] ansArr = new String[splited.length];
        for (int i=0; i<splited.length; i++) {
            int pos = Character.getNumericValue(splited[i].charAt(splited[i].length()-1));
            ansArr[pos-1] = splited[i].substring(0, splited[i].length()-1);
        }
        return String.join(" ", ansArr);
    }
}