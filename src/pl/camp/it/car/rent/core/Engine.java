package pl.camp.it.car.rent.core;

import pl.camp.it.car.rent.Authenticator;
import pl.camp.it.car.rent.database.IUserDB;
import pl.camp.it.car.rent.database.UserDB;
import pl.camp.it.car.rent.database.UserDB2;
import pl.camp.it.car.rent.database.VehicleDB;
import pl.camp.it.car.rent.gui.GUI;
import pl.camp.it.car.rent.model.User;
import java.io.IOException;


public class Engine {
    private static final Engine instance = new Engine();
    public static void start()  throws IOException {
        final VehicleDB vehicleDB = VehicleDB.getInstance();
        final IUserDB userDB = UserDB.getInstance();
        boolean isWorking = Authenticator.authenticate();


        while (isWorking) {
            GUI.showMenu();
            switch (GUI.reader.readLine()) {
                case "1":
                    GUI.listVehicles(vehicleDB.getVehicles());
                  break;
                case "2":
                   System.out.println("Plate:");
                    if (vehicleDB.rentVehicle(GUI.reader.readLine())) {
                        System.out.println("You have rent this vehicle !!!");
                    } else {
                        System.out.println("Rent error !!");
                    }
                    break;
                case "4":
                    GUI.reader.close();
                    isWorking = false;
                    vehicleDB.presistToFile();
                    userDB.presistToFile();


                    break;
                case "3":
                    if (Authenticator.loggedUser.getRole().equals(User.Role.ADMIN)) {
                        GUI.addVehicle(vehicleDB);
                        break;
                    }
                default:
                    System.out.println("Wrong choose !!");
                    break;
            }
        }
    }
}