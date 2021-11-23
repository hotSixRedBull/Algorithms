/**
 * @param {number} n
 */
var OrderedStream = function(n) {
    this.obj = {};
    this.index = 1;
};

/** 
 * @param {number} idKey 
 * @param {string} value
 * @return {string[]}
 */
OrderedStream.prototype.insert = function(idKey, value) {
    this.obj[idKey] = value;
    let ans = [];
    while (this.obj[this.index] != undefined) {
        ans.push(this.obj[this.index]);
        this.index++;
    }
    return ans;
};

/** 
 * Your OrderedStream object will be instantiated and called as such:
 * var obj = new OrderedStream(n)
 * var param_1 = obj.insert(idKey,value)
 */