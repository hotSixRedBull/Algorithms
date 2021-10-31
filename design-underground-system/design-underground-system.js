
var UndergroundSystem = function() {
    this.checkInMap = new Map();
    this.averageTimeMap = new Map();
};

/** 
 * @param {number} id 
 * @param {string} stationName 
 * @param {number} t
 * @return {void}
 */
UndergroundSystem.prototype.checkIn = function(id, stationName, t) {
    this.checkInMap.set(id, {
        stationName,
        t
    });
};

/** 
 * @param {number} id 
 * @param {string} stationName 
 * @param {number} t
 * @return {void}
 */
UndergroundSystem.prototype.checkOut = function(id, stationName, t) {
    let cur = this.checkInMap.get(id);
    let key = `${cur.stationName}-${stationName}`;
    if (!this.averageTimeMap.has(key)) {
        this.averageTimeMap.set(key, {
            'sum': t-cur.t,
            'cnt': 1
        });
    }
    else {
        let stored = this.averageTimeMap.get(key);
        this.averageTimeMap.set(key, {
            'sum': stored.sum+t-cur.t,
            'cnt': stored.cnt+1
        });
    }
};

/** 
 * @param {string} startStation 
 * @param {string} endStation
 * @return {number}
 */
UndergroundSystem.prototype.getAverageTime = function(startStation, endStation) {
    let key = `${startStation}-${endStation}`;
    let stored = this.averageTimeMap.get(key);
    return stored.sum/stored.cnt;
};

/** 
 * Your UndergroundSystem object will be instantiated and called as such:
 * var obj = new UndergroundSystem()
 * obj.checkIn(id,stationName,t)
 * obj.checkOut(id,stationName,t)
 * var param_3 = obj.getAverageTime(startStation,endStation)
 */