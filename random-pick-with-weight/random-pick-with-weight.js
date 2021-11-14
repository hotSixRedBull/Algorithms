/**
 * @param {number[]} w
 */
var Solution = function(w) {
    let sum = w.reduce((acc, item) => acc+=item);
    //console.log(sum);
    this.order = [];
    this.picked = 0;
    for (let i=0; i<w.length; i++) {
        for (let cnt=0; cnt<(w[i]/sum)*100; cnt++) {
            this.order.push(i);
        }
    }
    for (let i=0; i<this.order.length; i++) {
        let randomIndex = Math.floor(Math.random()*this.order.length);
        [this.order[randomIndex], this.order[i]] = [this.order[i], this.order[randomIndex]];
    }
    //console.log(this.order);
};

/**
 * @return {number}
 */
Solution.prototype.pickIndex = function() {
    if (this.picked >= this.order.length) {
        this.picked = 0;
    }
    return this.order[this.picked++];
};

/** 
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(w)
 * var param_1 = obj.pickIndex()
 */