class MyQueue {
    Stack<Integer> stk;
    Stack<Integer> stk2;
    public MyQueue() {
        stk = new Stack();
        stk2 = new Stack();
    }
    
    public void push(int x) {
        stk.push(x);
    }
    
    public int pop() {
        if (stk2.size() == 0) {
            while (stk.size() > 0) {
                stk2.push(stk.pop());
            }
        }
        return stk2.pop();
    }
    
    public int peek() {
        if (stk2.size() == 0) {
            while (stk.size() > 0) {
                stk2.push(stk.pop());
            }
        }
        return stk2.peek();
    }
    
    public boolean empty() {
        return stk.size() == 0 && stk2.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */