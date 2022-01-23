class BrowserHistory {
    Stack<String> backward;
    Stack<String> forward;
    String cur;
    public BrowserHistory(String homepage) {
        this.backward = new Stack<>();
        this.forward = new Stack<>();
        this.backward.add(homepage);
        this.cur = homepage;
    }
    
    public void visit(String url) {
        this.forward.clear();
        this.backward.add(url);
        this.cur = url;
    }
    
    public String back(int steps) {
        // System.out.println("backward "+steps+" steps, backward: "+this.backward);
        if (backward.size() > 0 && this.cur == this.backward.peek()) {
            this.backward.pop();
            if (this.forward.size() == 0 || (this.forward.size() > 0 && this.forward.peek() != this.cur)) {
                this.forward.add(this.cur);
            }
        }
        String cur = this.cur;
        while (steps > 0 && backward.size() > 0) {
            cur = this.backward.pop();
            this.forward.add(cur);
            steps--;
        }
        this.backward.add(cur);
        this.cur = cur;
        return cur;
    }
    
    public String forward(int steps) {
        // System.out.println("forward "+steps+" steps, backward: "+this.backward);
        if (forward.size() > 0 && this.cur == this.forward.peek()) {
            forward.pop();
            if (this.backward.size() == 0 || (this.backward.size() > 0 && this.backward.peek() != this.cur)) {
                backward.add(this.cur);
            }
        }
        String cur = this.cur;
        while (steps > 0 && forward.size() > 0) {
            cur = this.forward.pop();
            this.backward.add(cur);
            steps--;
        }
        this.forward.add(cur);
        this.cur = cur;
        return cur;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */