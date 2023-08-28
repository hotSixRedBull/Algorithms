class MyStack {
    Queue<Integer> a,b;
    public MyStack() {
        a = new ArrayDeque();
        b = new ArrayDeque();
    }
    
    public void push(int x) {
        if (b.size() == 1) {
            a.add(b.poll());
        }
        b.add(x);
    }
    
    public int pop() {
        if (b.size() == 0) {
            while (a.size() > 1) {
                b.add(a.poll());
            }
            Queue<Integer> tmp = b;
            b = a;
            a = tmp;
        }
        return b.poll();
    }
    
    public int top() {
        if (b.size() == 0) {
            while (a.size() > 1) {
                b.add(a.poll());
            }
            Queue<Integer> tmp = b;
            b = a;
            a = tmp;
        }
        return b.peek();
    }
    
    public boolean empty() {
        return a.size() == 0 && b.size() == 0;
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