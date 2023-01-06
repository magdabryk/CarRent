package pl.camp.it.car.rent.database;

import pl.camp.it.car.rent.exceptions.IllegalDataInDatabaseFile;
import pl.camp.it.car.rent.model.Bus;
import pl.camp.it.car.rent.model.Car;
import pl.camp.it.car.rent.model.Motorcycle;
import pl.camp.it.car.rent.model.Vehicle;


import java.io.*;

import java.util.ArrayList;

public class VehicleDB implements IVechicleDB {
    private final ArrayList<Vehicle> vehicles = new ArrayList();
    private final String VEHICLE_DB_FILE = "vehicles.txt";
    private static final VehicleDB instance = new VehicleDB();

    private VehicleDB() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(VEHICLE_DB_FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                Vehicle vehicle = convertDataToVehicle(line);
                this.vehicles.add(vehicle);
            }
        } catch (IOException e) {
            System.out.println("bład odczyt z pliku");
        }
    }

    public boolean rentVehicle(String plate) {
        for (Vehicle currentVehicle : this.vehicles) {
            if (currentVehicle.getPlate().equals(plate) && !currentVehicle.isRent()) {
                currentVehicle.setRent(true);
                return true;
            }
        }
        return false;
    }


    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void presistToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.VEHICLE_DB_FILE));

            writer.write(this.vehicles.get(0).convertToData());
            for (int i = 1; i < vehicles.size(); i++) {
                writer.newLine();
                writer.write(this.vehicles.get(i).convertToData());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("bład podczas zapisu");
            e.printStackTrace();
        }
    }

    private Vehicle convertDataToVehicle(String data) {
        String[] vehicleData = data.split(";");
        switch (vehicleData[0]) {
            case "Car":
                return new Car(vehicleData);

            case "Bus":
                return new Bus(vehicleData);

            case "Motorcycle":
                return new Motorcycle(vehicleData);

            default:
                try {
                    throw new IllegalDataInDatabaseFile();
                } catch (IllegalDataInDatabaseFile e) {
                    e.printStackTrace();
                }


        }
        return null;
    }
public static VehicleDB getInstance() {
        return instance;
}

}


