
var MinStack = function() {
    this.stk = [];
};

/** 
 * @param {number} val
 * @return {void}
 */
MinStack.prototype.push = function(val) {
    if (this.min == undefined) {
        this.min = val;
    }
    else if (this.min != undefined && this.min > val) {
        this.min = val;
    }
    this.stk.push(val);
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    let res = this.stk.pop();
    if (res == this.min) {
        this.min = Math.min(...this.stk);
    }
    return res;
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    return this.stk[this.stk.length-1];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    return this.min;
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */