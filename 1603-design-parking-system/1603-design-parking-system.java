class ParkingSystem {
    int b;
    int m;
    int s;
    public ParkingSystem(int big, int medium, int small) {
        this.b = big;
        this.m = medium;
        this.s = small;
    }
    
    public boolean addCar(int carType) {
        if (carType == 1) {
            if (b == 0) {
                return false;
            }
            b--;
        }
        else if (carType == 2) {
            if (m == 0) {
                return false;
            }
            m--;
        }
        else {
            if (s == 0) {
                return false;
            }
            s--;
        }
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */