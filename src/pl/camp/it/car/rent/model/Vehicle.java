package pl.camp.it.car.rent.model;

public class Vehicle {

    private String brand;
    private String model;
    private int year;
    private boolean rent;
    private String plate;
    private double price;

    public Vehicle() {
    }

    public Vehicle(String brand, String model, int year, boolean rent, String plate, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.rent = rent;
        this.plate = plate;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isRent() {
        return rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
