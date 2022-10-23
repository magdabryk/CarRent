package pl.camp.it.car.rent.model;

public class Bus extends Vehicle {

    private int seats;

    public Bus(String brand, String model, int year, boolean rent, String plate, double price, int seats) {
        super(brand, model, year, rent, plate, price);
        this.seats = seats;
    }

    public Bus() {
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}


