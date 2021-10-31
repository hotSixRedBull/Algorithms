class node {
  constructor(val, timestamp) {
      this.val = val;
      this.timestamp = timestamp;
      this.left = null;
      this.right = null;
  }
};


var TimeMap = function() {
    this.map = new Map();
};

/** 
 * @param {string} key 
 * @param {string} value 
 * @param {number} timestamp
 * @return {void}
 */
TimeMap.prototype.set = function(key, value, timestamp) {
    let map = this.map;
    if (!!map.has(key)) {
        let cur = map.get(key);
        let prev = null;
        while (!!cur) {
            if (cur.timestamp <= timestamp && !!cur.left) {
                prev = cur;
                cur = cur.left;
            }
            else if(cur.timestamp > timestamp && !!cur.right) {
                prev = cur;
                cur = cur.right;
            }
            else {
                break;
            }
        }
        if (prev == null) {
            prev = cur;
        }
        if (prev.timestamp > timestamp) {
            prev.left = new node(value, timestamp);
        }
        else {
            prev.right = new node(value, timestamp);
        }
    }
    else {
        map.set(key, new node(value, timestamp));
    }
    //console.log('set map', map);
};

/** 
 * @param {string} key 
 * @param {number} timestamp
 * @return {string}
 */
TimeMap.prototype.get = function(key, timestamp) {
    //console.log("!!!get: ", key, timestamp)
    let map = this.map;
    // console.log('get map', map);
    if (!map.has(key)){
        return "";
    }
    else {
        let cur = map.get(key);
        //console.log(`map.get(${key}): ${cur}`);
        let prev = null;
        while (!!cur) {
            //console.log('cur', cur);
            if (cur.timestamp > timestamp && !!cur.left) {
                prev = cur;
                cur = cur.left;
            }
            else if(cur.timestamp < timestamp && !!cur.right) {
                prev = cur;
                cur = cur.right;
            }
            else {
                if (!!cur && cur.timestamp <= timestamp) {
                    prev = cur;
                }
                break;
            }
        }
        if (prev == null) {
            prev = cur;
        }
        if (prev.timestamp > timestamp) {
            return "";
        }
        else {
            return prev.val;
        }
    }
};

/** 
 * Your TimeMap object will be instantiated and called as such:
 * var obj = new TimeMap()
 * obj.set(key,value,timestamp)
 * var param_2 = obj.get(key,timestamp)
 */