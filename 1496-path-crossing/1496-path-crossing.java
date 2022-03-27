import java.util.*;

class Solution {
    public boolean isPathCrossing(String path) {
        int nsCnt = 0;
        int ewCnt = 0;
        Set<String> visited = new HashSet();
        visited.add(String.format("ewCnt: %d, nsCnt: %d", 0, 0));
        for (int i=0; i<path.length(); i++) {
            if (path.charAt(i) == 'E') {
                ewCnt--;
            }
            else if (path.charAt(i) == 'W') {
                ewCnt++;
            }
            else if (path.charAt(i) == 'S') {
                nsCnt++;
            }
            else if (path.charAt(i) == 'N') {
                nsCnt--;
            }
            
            String key = String.format("ewCnt: %d, nsCnt: %d", ewCnt, nsCnt);
            if (visited.contains(key)) {
                return true;
            }
            visited.add(key);
        }
        return false;
    }
}