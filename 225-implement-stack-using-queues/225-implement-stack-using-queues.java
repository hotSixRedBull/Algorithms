class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new ArrayDeque();
        q2 = new ArrayDeque();
    }
    
    public void push(int x) {
        if (q2.size() != 0) {
            q1.add(q2.poll());
        }
        q2.add(x);
    }
    
    public int pop() {
        /*
        if (empty() == true) {
            return -1; // size is empty
        }
        */
        if (q2.size() == 0) {
            fillQ2();
        }
        return q2.poll();
    }
    
    public int top() {
        /*
        if (empty() == true) {
            return -1; // size is empty
        }
        */
        if (q2.size() == 0) {
            fillQ2();
        }
        return q2.peek();
    }
    
    public void fillQ2() {
        if (q2.size() == 1) {
            return;
        }
        while(q1.size()>0) {
            q2.add(q1.poll());
        }
        while(q2.size()>1) {
            q1.add(q2.poll());
        }
    }
    
    public boolean empty() {
        return q1.size() == 0 && q2.size() == 0;
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