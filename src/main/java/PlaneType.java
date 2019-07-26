public enum PlaneType {
    BOEING747(200, 16000.0),
    FIXEDWING(2, 200.0);

    private final int capacity;
    private final double totalWeight;

    PlaneType (int capacity, double totalWeight) {
        this.capacity = capacity;
        this.totalWeight = totalWeight;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getTotalWeight() {
        return totalWeight;
    }
}
