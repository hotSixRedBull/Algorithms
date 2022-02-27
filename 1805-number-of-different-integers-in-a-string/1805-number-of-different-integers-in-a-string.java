class Solution {
    public int numDifferentIntegers(String word) {
        word = word.replaceAll("[a-z]+", " ");
        word = word.replaceAll("[ ]+", " ");
        word = word.replaceAll("^0+([0-9]+)", "$1");
        word = word.replaceAll(" 0+([0-9]+)", " $1");
        String[] arr = word.split(" ");
        Set<String> set = new HashSet();
        for (String s : arr) {
            if (s.length() != 0) {
                set.add(s);
            }
        }
        return set.size();
    }
}

//"4r05743a05743n05743yoe"
