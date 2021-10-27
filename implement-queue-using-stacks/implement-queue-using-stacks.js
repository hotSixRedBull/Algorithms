
var MyQueue = function() {
    this.q = [];
    this.reverseQ = [];
};

/** 
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function(x) {
    this.reverseQ = [];
    while (this.q.length > 0) {
        this.reverseQ.push(this.q.pop());
    }
    this.reverseQ.push(x);
    while (this.reverseQ.length > 0) {
        this.q.push(this.reverseQ.pop());
    }
};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function() {
    return this.q.pop();
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function() {
    return this.q[this.q.length-1];
};

/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function() {
    return this.q.length == 0;
};

/** 
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */