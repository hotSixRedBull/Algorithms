class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> s = new ArrayDeque();
        for (int i=0; i<students.length; i++) {
            s.add(students[i]);
        }
        int prev = students.length-1;
        for (int i=0; i<sandwiches.length; i++) {
            int sSiz = s.size();
            for (int j=0; j<sSiz; j++) {
                if (s.peek() == sandwiches[i]) {
                    s.poll();
                    break;
                }
                else {
                    s.add(s.poll());
                }
                if (j == sSiz-1) {
                    return sandwiches.length-i;
                }
            }
        }
        return 0;
    }
}