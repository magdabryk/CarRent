package pl.camp.it.car.rent.model;

public class Car extends Vehicle{

    public Car(String brand, String model, int year, boolean rent, String plate, double price) {
        super(brand, model, year, rent, plate, price);
    }

    public Car() {
    }
}