class ParkingSystem {

    int big;
    int medium;
    int small;

    // Constructor
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    // Method to add car
    public boolean addCar(int carType) {
        if (carType == 1) { // Big
            if (big > 0) {
                big--;
                return true;
            }
        } else if (carType == 2) { // Medium
            if (medium > 0) {
                medium--;
                return true;
            }
        } else if (carType == 3) { // Small
            if (small > 0) {
                small--;
                return true;
            }
        }
        return false;
    }
}