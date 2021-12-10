class MyStack {
    private Queue<Integer> normalQ;
    private Queue<Integer> reverseQ;
    public MyStack() {
        normalQ = new ArrayDeque<>();
        reverseQ = new ArrayDeque<>();
    }
    
    public void push(int x) {
        normalQ.add(x);
    }
    
    public int pop() {
        int size = normalQ.size();
        for (int i=0; i<size-1; i++) {
            reverseQ.add(normalQ.poll());
        }
        Iterator<Integer> iterator = reverseQ.iterator();
        while (iterator.hasNext()) {
            normalQ.add(iterator.next());
        }
        reverseQ.clear();
        System.out.println("[pop] normalQ" + normalQ);
        System.out.println("[pop] reverseQ" + reverseQ);
        return normalQ.poll();
    }
    
    public int top() {
        int size = normalQ.size();
        for (int i=0; i<size-1; i++) {
            reverseQ.add(normalQ.poll());
        }
        int res = normalQ.poll();
        reverseQ.add(res);
        Iterator<Integer> iterator = reverseQ.iterator();
        while (iterator.hasNext()) {
            normalQ.add(iterator.next());
        }
        reverseQ.clear();
        System.out.println("[top] normalQ" + normalQ);
        System.out.println("[top] reverseQ" + reverseQ);
        return res;
    }
    
    public boolean empty() {
        return normalQ.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */