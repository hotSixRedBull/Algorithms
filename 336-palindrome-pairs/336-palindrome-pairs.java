// saw solution
class Solution {
    private static class TrieNode {
        TrieNode[] next;
        int index;
        List<Integer> list;

        TrieNode() {
            next = new TrieNode[26];
            index = -1;
            list = new ArrayList<>();
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();

        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            search(words, i, root, res);
        }

        return res;
    }

    private void addWord(TrieNode root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int j = word.charAt(i) - 'a';

            if (root.next[j] == null) {
                root.next[j] = new TrieNode();
            }

            if (isPalindrome(word, 0, i)) {
                root.list.add(index);
            }

            root = root.next[j];
        }

        root.list.add(index);
        root.index = index;
    }

    private void search(String[] words, int i, TrieNode root, List<List<Integer>> res) {
        for (int j = 0; j < words[i].length(); j++) {	
            if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
                res.add(Arrays.asList(i, root.index));
            }

            root = root.next[words[i].charAt(j) - 'a'];
            if (root == null) return;
        }

        for (int j : root.list) {
            if (i == j) continue;
            res.add(Arrays.asList(i, j));
        }
    }

    private boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }

        return true;
    }
}
/*
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Set<Character>[] set = new HashSet[words.length];
        for (int i=0; i<words.length; i++) {
            set[i] = new HashSet();
            for (int j=0; j<words[i].length(); j++) {
                set[i].add(words[i].charAt(j));
            }
        }
        
        List<List<Integer>> answer = new ArrayList();
        for (int i=0; i<words.length; i++) {
            for (int j=0; j<words.length; j++) {
                // if (i == 101 && j == 56) {
                //     System.out.println(String.format("words[i]: %s, words[j]: %s", words[i], words[j]));
                // }
                if (i == j) {
                    continue;
                }
                Set<Character> union = new HashSet(set[i]);
                union.addAll(set[j]);
                // if (i == 101 && j == 56) {
                //     System.out.println(String.format("union : %s", union));
                // }
                String concatenated = words[i]+words[j];
                // if (i == 101 && j == 56) {
                // System.out.println(String.format("concatenated: %s", concatenated));
                // }
                int left = 0;
                int right = concatenated.length()-1;
                boolean isPal = true;
                while (left < right) {
                    if (concatenated.charAt(left) != concatenated.charAt(right)) {
                        isPal = false;
                        break;
                    }
                    left++;
                    right--;
                }
                if (isPal) {
                    answer.add(new ArrayList(List.of(i,j)));
                }
            }
        }
        return answer;
    }
}

*/


/*
pre processing
set에 저장해서, 후보군만 살펴본다.
정렬된 텍스트 자체를 키값으로? 흠..
근데 palindrome이 되려면, 중간에 있는 글자는 혼자 가지고 있어도 되잖아.
aaa 와 aaaaaaaaaa 도 후보

O(N^2) -> 5000*5000 -> 25000000
*
O(pal) < 4?

"aba" "" -> true
*/