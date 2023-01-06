package pl.camp.it.car.rent.database;

import pl.camp.it.car.rent.model.Vehicle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public interface IVechicleDB {
    boolean rentVehicle(String plate) ;


    void addVehicle(Vehicle vehicle) ;

    ArrayList<Vehicle> getVehicles() ;

    void presistToFile() ;
}
