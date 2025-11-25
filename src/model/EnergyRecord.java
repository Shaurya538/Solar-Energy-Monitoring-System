package model;

public class EnergyRecord {
    private double production;
    private double consumption;
    private double storage;

    public EnergyRecord(double production, double consumption, double storage) {
        this.production = production;
        this.consumption = consumption;
        this.storage = storage;
    }

    public double getProduction() { return production; }
    public double getConsumption() { return consumption; }
    public double getStorage() { return storage; }
}
