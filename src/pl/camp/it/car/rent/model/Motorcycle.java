package pl.camp.it.car.rent.model;

public class Motorcycle extends Vehicle{

    private boolean cart;

    public Motorcycle() {
    }

    public Motorcycle(String brand, String model, int year,  String plate, double price, boolean cart) {
        super(brand, model, year, plate, price);
        this.cart = cart;
    }



    public boolean isCart() {
        return cart;
    }

    public void setCart(boolean cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return super.toString() + " Boczny wózek: " + (this.cart ? "tak" : "nie");
    }
}
