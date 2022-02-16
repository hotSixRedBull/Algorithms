class StringIterator {
    char[] elem;
    int[] freq;
    int cur;
    int size;
    public StringIterator(String compressedString) {
        elem = new char[compressedString.length()];
        freq = new int[compressedString.length()];
        size = 0;
        cur = 0;
        for (int i=0; i<compressedString.length(); i++) {
            char c = compressedString.charAt(i);
            // System.out.println("c: "+c);
            int numberEndIndex = i+1;
            while (numberEndIndex < compressedString.length()
                   && compressedString.charAt(numberEndIndex) <= '9' 
                   && compressedString.charAt(numberEndIndex) >= '0') {
                // System.out.println("compressedString.charAt(numberEndIndex): "+compressedString.charAt(numberEndIndex));
                numberEndIndex++;
            }
            int cnt = Integer.parseInt(compressedString.substring(i+1, numberEndIndex));
            i = numberEndIndex-1;
            elem[size] = c;
            freq[size++] = cnt;
        }
    }
    
    public char next() {
        char ans = ' ';
        if (cur < size) {
            if (freq[cur] > 0) {
                ans = elem[cur];
                freq[cur]--;
                if (freq[cur] == 0) {
                    cur++;
                }
            }
        }
        return ans;
    }
    
    public boolean hasNext() {
        return cur < size && freq[cur] > 0;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */