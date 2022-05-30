class Solution {
    public String crackSafe(int n, int k) {
        String base = "0";
        base = base.repeat(n);
        StringBuilder stringbuilder = new StringBuilder(base);
        
        Set<String> visited = new HashSet();
        visited.add(base);
        
        backtrack(stringbuilder, visited, (int) Math.pow(k,n), n, k);
        return stringbuilder.toString();
    }
    
    public boolean backtrack(StringBuilder built, Set<String> visited, int end, int n, int k) {
        if (visited.size() == end) {
            System.out.println(built);
            return true;
        }
        
        String prefix = built.substring(built.length()-n+1, built.length());
        for (int i=0; i<k; i++)  {
            char c = '0';
            c += i;
            if (!visited.contains(prefix+c)) {
                visited.add(prefix+c);
                built.append(c);
                if (backtrack(built, visited, end, n, k)) {
                    return true;
                }
                visited.remove(prefix+c);
                built.deleteCharAt(built.length()-1);
            }
        }
        
        return false;
    }
}