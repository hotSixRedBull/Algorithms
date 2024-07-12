//saw solution
class Solution {

    public int maximumGain(String s, int x, int y) {
        int totalScore = 0;
        String highPriorityPair = x > y ? "ab" : "ba";
        String lowPriorityPair = highPriorityPair.equals("ab") ? "ba" : "ab";

        // First pass: remove high priority pair
        String stringAfterFirstPass = removeSubstring(s, highPriorityPair);
        int removedPairsCount =
            (s.length() - stringAfterFirstPass.length()) / 2;

        // Calculate score from first pass
        totalScore += removedPairsCount * Math.max(x, y);

        // Second pass: remove low priority pair
        String stringAfterSecondPass = removeSubstring(
            stringAfterFirstPass,
            lowPriorityPair
        );
        removedPairsCount = (stringAfterFirstPass.length() -
            stringAfterSecondPass.length()) /
        2;

        // Calculate score from second pass
        totalScore += removedPairsCount * Math.min(x, y);

        return totalScore;
    }

    private String removeSubstring(String input, String targetPair) {
        Stack<Character> charStack = new Stack<>();

        // Iterate through each character in the input string
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            // Check if current character forms the target pair with the top of the stack
            if (
                currentChar == targetPair.charAt(1) &&
                !charStack.isEmpty() &&
                charStack.peek() == targetPair.charAt(0)
            ) {
                charStack.pop(); // Remove the matching character from the stack
            } else {
                charStack.push(currentChar);
            }
        }

        // Reconstruct the remaining string after removing target pairs
        StringBuilder remainingChars = new StringBuilder();
        while (!charStack.isEmpty()) {
            remainingChars.append(charStack.pop());
        }
        return remainingChars.reverse().toString();
    }
}
/*
class Solution {
    Map<String, Integer> cache;
    
    public Solution() {
        cache = new HashMap();
    }
    
    public int maximumGain(String s, int x, int y) {
        cache.put("", 0);
        cache.put("a", 0);
        cache.put("a", 0);
        cache.put("ab", x);
        cache.put("ba", y);
        int start = 0;
        while (start < s.length()
               && s.charAt(start) != 'a' 
               && s.charAt(start) != 'b') {
            start++;
        }
        // System.out.println(start);
        List<String> li = new ArrayList();
        for (int i=start; i<s.length(); i++) {
            if (i < start) {
                continue;
            }
            if (s.charAt(i) != 'a' && s.charAt(i) != 'b') {
                li.add(s.substring(start, i));
                // System.out.println(li);
                start = i+1;
                while (start < s.length()
                       && s.charAt(start) != 'a' 
                       && s.charAt(start) != 'b') {
                    start++;
                }
                // System.out.println(start);
            }
        }
        if (start < s.length()) {
            li.add(s.substring(start, s.length()));
            // System.out.println(li);
        }
        // System.out.println(li);
        int max = 0;
        for (String str : li) {
            max += getMax(str, x,  y);
        }
        // System.out.println(cache);
        return max;
    }
    
    public int getMax(String str, int x, int y) {
        if (cache.containsKey(str)) {
            return cache.get(str);
        }
        int max = 0;
        for (int i=0; i<str.length()-1; i++) {
            if (str.charAt(i) == 'a' && str.charAt(i+1) == 'b') {
                // System.out.println(String.format("11111 str: %s, i: %d", str, i));
                int localMax = x;
                if (i != 0) {
                    if (i+2 < str.length()) {
                        localMax += getMax(str.substring(0,i)+str.substring(i+2,str.length()),x,y);
                    }
                    else {
                        localMax += getMax(str.substring(0,i),x,y);
                    }
                }
                else if (i+2 < str.length()) {
                    localMax += getMax(str.substring(i+2,str.length()),x,y);
                }
                max = Math.max(max, localMax);
                // System.out.println(String.format("pass1, max: %d, localMax: %d", max, localMax));
            }
            else if (str.charAt(i) == 'b' && str.charAt(i+1) == 'a') {
                // System.out.println(String.format("22222 str: %s, i: %d", str, i));
                int localMax = y;
                if (i != 0) {
                    if (i+2 < str.length()) {
                        localMax += getMax(str.substring(0,i)+str.substring(i+2,str.length()),x,y);
                    }
                    else {
                        localMax += getMax(str.substring(0,i),x,y);
                    }
                }
                else if (i+2 < str.length()) {
                    localMax += getMax(str.substring(i+2,str.length()),x,y);
                }
                max = Math.max(max, localMax);
                // System.out.println(String.format("pass2, max: %d, localMax: %d", max, localMax));
            }
        }
        cache.put(str, max);
        // System.out.println(String.format("str: %s, max: %d", str, max));
        return max;
    }
}
/*
DP?

"b" "bbaaabab" = 19
"b" "bbaaab" = 14
"b" "bbaa" = 10
"b" "ba" = 5
*/