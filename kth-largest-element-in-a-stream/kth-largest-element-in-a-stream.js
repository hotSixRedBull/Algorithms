/**
 * @param {number} k
 * @param {number[]} nums
 */
var KthLargest = function(k, nums) {
    this.nums = nums.sort((a, b) => b - a);
    this.k = k-1;
    this.kth = undefined;
    if (this.nums.length > this.k) {
        this.kth = this.nums[this.k];
    }
};

/** 
 * @param {number} val
 * @return {number}
 */
KthLargest.prototype.add = function(val) {
    this.nums.push(val);
    if (this.nums.length > this.k && (val > this.kth || this.kth == undefined)) {
        this.nums = this.nums.sort((a, b) => b - a);
        this.kth = this.nums[this.k];
    }
    return this.kth;
};

/** 
 * Your KthLargest object will be instantiated and called as such:
 * var obj = new KthLargest(k, nums)
 * var param_1 = obj.add(val)
 */