/*
0
1 2
3456
*/
// maxHeap
class heap {
    constructor() {
        this.arr = [];
    }
    getSize() {
        return this.arr.length;
    }
    put(val) {
        this.arr.push(val);
        let curIndex = this.arr.length-1;
        do {
            let parentIndex = Math.floor((curIndex-1)/2);
            if (this.arr[parentIndex] < this.arr[curIndex]) {
                [this.arr[curIndex], this.arr[parentIndex]] = [this.arr[parentIndex], this.arr[curIndex]];
                curIndex = parentIndex;
            }
            else {
                break;
            }
        } while (curIndex > 0);
    }
    pop() {
        let ret = this.arr[0];
        this.arr[0] = this.arr[this.arr.length-1];
        this.arr.pop();
        let curIndex = 0;
        while (curIndex < this.arr.length) {
            let leftIndex = curIndex*2+1;
            let rightIndex = curIndex*2+2;
            if (rightIndex < this.arr.length-1) {
                if (this.arr[rightIndex] > this.arr[leftIndex]) {
                    if (this.arr[curIndex] < this.arr[rightIndex]) {
                        [this.arr[curIndex], this.arr[rightIndex]] = [this.arr[rightIndex], this.arr[curIndex]];
                    curIndex = rightIndex;
                    }
                    else {
                        break;
                    }
                }
                else {
                    if (this.arr[curIndex] < this.arr[leftIndex]) {
                        [this.arr[curIndex], this.arr[leftIndex]] = [this.arr[leftIndex], this.arr[curIndex]];
                    curIndex = leftIndex;
                    }
                    else {
                        break;
                    }
                }
            }
            else if (leftIndex < this.arr.length-1) {
                if (this.arr[curIndex] < this.arr[leftIndex]) {
                    [this.arr[curIndex], this.arr[leftIndex]] = [this.arr[leftIndex], this.arr[curIndex]];
                    curIndex = leftIndex;
                }
                else {
                    break;
                }
            }
            else {
                break;
            }
        }
        return ret;
    }
    print() {
        console.log(this.arr);
    }
}
/**
 * @param {number[][]} intervals
 * @return {number}
 */
var minMeetingRooms = function(intervals) {
    let h = new heap();
    intervals.sort((a, b) => {
        if (a[1] == b[1]) {
            return a[0]-b[0];
        }
        return a[1]-b[1];
    });
    for (let i=0;i<intervals.length;i++) {
        if (h.getSize() == 0) {
            h.put(intervals[i][1]);
        }
        else {
            let stk = [];
            let max;
            let changed = false;
            do {
                max = h.pop();
                if (max <= intervals[i][0]) {
                    max = intervals[i][1];
                    h.put(max);
                    changed = true;
                    break;
                }
                else {
                    stk.push(max);
                }
            } while(h.getSize() > 0);
            while (stk.length > 0) {
                let popped = stk.pop();
                h.put(popped);
            }
            if (!changed) {
                h.put(intervals[i][1]);
            }
        }
    };
    //h.print();
    return h.getSize();
}
/*
TC
[[2,15],[36,45],[9,29],[16,23],[4,9]]
*/