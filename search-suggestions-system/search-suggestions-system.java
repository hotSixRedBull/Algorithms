class Solution {
    class Node {
        public HashMap<Character, Node> hashMap;
        public List<String> strs;
        public Node() {
            hashMap = new HashMap<Character, Node>();
            strs = new ArrayList<>();
        }
        public void insert(String str, int index) {
            strs.add(str);
            strs.sort(new Comparator<String>() {
                @Override
                public int compare(String str1, String str2) {
                    return str1.compareTo(str2);
                }
            });
            if (index >= str.length()) {
                return;
            }
            
            if (hashMap.containsKey(str.charAt(index))) {
                hashMap.get(str.charAt(index)).insert(str, index+1);    
            }
            else {
                Node tmp = new Node();
                tmp.insert(str, index+1);
                hashMap.put(str.charAt(index), tmp);
            }
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node hashMap = new Node();
        for (String product : products) {
            hashMap.insert(product, 0);
        }
        //System.out.println(hashMap);
        
        Node hashMapCursor = hashMap;
        List<List<String>> answer = new ArrayList<>();
        for (char c : searchWord.toCharArray()) {
            if (hashMapCursor != null && hashMapCursor.hashMap.containsKey(c)) {
                hashMapCursor = hashMapCursor.hashMap.get(c);
                if (hashMapCursor.strs.size() > 3) {
                    List<String> tmp = new ArrayList<>();
                    for (int i=0; i<3; i++) {
                        tmp.add(hashMapCursor.strs.get(i));
                    }
                    hashMapCursor.strs = tmp;
                }
                answer.add(hashMapCursor.strs);
            }
            else {
                hashMapCursor = null;
                answer.add(new ArrayList<String>());
            }
        }
        
        return answer;
    }
}