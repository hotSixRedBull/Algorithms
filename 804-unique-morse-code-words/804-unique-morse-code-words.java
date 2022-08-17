class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> transformations = new HashSet();
        for (String word : words) {
            String transformed = "";
            for (int i=0; i<word.length(); i++) {
                transformed += morse[word.charAt(i)-'a'];
            }
            transformations.add(transformed);
        }
        return transformations.size();
    }
}