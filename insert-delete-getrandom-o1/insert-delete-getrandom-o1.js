
var RandomizedSet = function() {
    this.list = [];
    this.obj = {};
};

/** 
 * @param {number} val
 * @return {boolean}
 */
RandomizedSet.prototype.insert = function(val) {
    if (this.obj[val.toString()] != undefined) {
       return false; 
    }
    this.obj[val] = this.list.length;
    this.list.push(val);
    return true;
};

/** 
 * @param {number} val
 * @return {boolean}
 */
RandomizedSet.prototype.remove = function(val) {
    if (this.obj[val.toString()] != undefined) {
        let index1 = this.list.length-1;
        let index2 = this.obj[val.toString()];
        [this.list[index1], this.list[index2]] = [this.list[index2], this.list[index1]]
        this.list.pop();
        this.obj[this.list[index2]] = index2;
        delete this.obj[val.toString()];
        return true; 
    }
    return false;
};

/**
 * @return {number}
 */
RandomizedSet.prototype.getRandom = function() {
    let targetIndex = Math.floor(Math.random()*this.list.length);
    return this.list[targetIndex];
};

/** 
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = new RandomizedSet()
 * var param_1 = obj.insert(val)
 * var param_2 = obj.remove(val)
 * var param_3 = obj.getRandom()
 */