// saw solution
// but wrote code on my own after understanding it
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int[] maxDefense = new int[100001];
        int maxAttackValueFromAll = Integer.MIN_VALUE;
        for (int[] property : properties) {
            maxAttackValueFromAll = Math.max(maxAttackValueFromAll, property[0]);
            maxDefense[property[0]] = Math.max(maxDefense[property[0]], property[1]);
        }
        for (int i=maxAttackValueFromAll-1; i>=0; i--) {
            maxDefense[i] = Math.max(maxDefense[i+1], maxDefense[i]);
        }
        // System.out.println(Arrays.toString(Arrays.copyOfRange(maxDefense,0,maxAttackValueFromAll)));
        int cnt = 0;
        for (int[] property : properties) {
            if (property[0] < 100000
                && maxDefense[property[0]+1] > property[1]) {
                cnt++;
            }
        }
        return cnt;
    }
}
/*
class AttackSortComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        if (a[0] == b[0]) {
            return a[1]-b[1];
        }
        return a[0]-b[0];
    }
}

class DefenseSortComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        if (a[1] == b[1]) {
            return a[0]-b[0];
        }
        return a[1]-b[1];
    }
}

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        List<int[]> attack = new ArrayList<int[]>();
        List<int[]> defense = new ArrayList<int[]>();
        for (int[] character : properties) {
            attack.add(character);
            defense.add(character);
        }
        Collections.sort(attack, new AttackSortComparator());
        Collections.sort(defense, new DefenseSortComparator());
        int cnt = 0;
        for (int[] character : properties) {
            // System.out.println(String.format("[[start]]\nattack: %s,\ndefense: %s", Arrays.deepToString(attack.toArray()), Arrays.deepToString(defense.toArray())));
            int atkIndex = Collections.binarySearch(attack, new int[]{character[0]+1,character[1]}, new AttackSortComparator());
            int dfsIndex = Collections.binarySearch(defense, new int[]{character[0], character[1]+1}, new DefenseSortComparator());
            // System.out.println(String.format("atkIndex: %d, dfsIndex: %d", atkIndex, dfsIndex));
            if (atkIndex == -1
               || dfsIndex == -1) {
                continue;
            }
            if (atkIndex < 0) {
                atkIndex = -atkIndex-1;
            }
            if (dfsIndex < 0) {
                dfsIndex = -dfsIndex-1;
            }
            List<int[]> atkList = new ArrayList();
            if (atkIndex < attack.size()) {
                atkList = attack.subList(atkIndex, attack.size());
            }
            List<int[]> dfsList = new ArrayList();
            if (dfsIndex < defense.size()) {
                dfsList = defense.subList(dfsIndex, defense.size());
            }
            Set<int[]> atk = new HashSet(atkList);
            Set<int[]> dfs = new HashSet(dfsList);
            // System.out.println(String.format("character: %s,\natk: %s,\ndfs: %s",Arrays.toString(character), Arrays.deepToString(atk.toArray()), Arrays.deepToString(dfs.toArray())));
            atk.addAll(dfs);
            // System.out.println(String.format("retained: %s",Arrays.deepToString(atk.toArray())));
            if(atk.size() < atkList.size()+dfsList.size()) {
                cnt++;
            }
        }
        return cnt;
    }
}
*/
/*
seems like a sorting problem.

A1. brute force, O(n^2)
- compare all pairs

A2. sort, O(nlogn)  ~~~~
- sort and loop through the sorted array.
- I donno how yet

A3. binary search? ~~~~
- what if i put those in a binary search tree?
- first, i use attack as a key
    - if there are elements, compare defenses? hmm.. that would cost O(n^2)
    
A4. TreeMap with set
- Two treeMaps
- each use attack, defense as a key
    - O(n) + O(n)
- find all the groups and use intersection of those
    - * O(n)
    
    
character: [5, 5], atk: [[I@20ad9418, [I@31cefde0], dfs: [[I@20ad9418, [I@439f5b3d]
character: [6, 3], atk: [], dfs: [[I@31cefde0, [I@20ad9418, [I@439f5b3d]
character: [3, 6], atk: [[I@439f5b3d, [I@20ad9418], dfs: [[I@439f5b3d]


[[1,1],[2,1],[2,2],[1,2]]
[[7,9],[10,7],[6,9],[10,4],[7,5],[7,10]]
*/