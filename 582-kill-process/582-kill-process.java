class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> children = new HashMap();
        for (int i=0; i<pid.size(); i++) {
            if (ppid.get(i) == 0) {
                continue;
            }
            if (!children.containsKey(ppid.get(i))) {
                children.put(ppid.get(i), new ArrayList());
            }
            children.get(ppid.get(i)).add(pid.get(i));
        }
        Stack<Integer> stk = new Stack();
        stk.add(kill);
        List<Integer> answer = new ArrayList();
        while (stk.size() > 0) {
            int cur = stk.pop();
            answer.add(cur);
            List<Integer> childList = children.getOrDefault(cur, new ArrayList());
            for (int child : childList) {
                stk.add(child);
            }
        }
        return answer;
    }
}