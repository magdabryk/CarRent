package pl.camp.it.car.rent;
import pl.camp.it.car.rent.database.UserDB;

import pl.camp.it.car.rent.gui.GUI;
import pl.camp.it.car.rent.model.User;

import javax.imageio.IIOException;
import java.io.IOException;

public class Authenticator {
    public static String seed = "1Tl8*G3Ertpxvj0%8qpy";
    public static User loggedUser;

    public static boolean authenticate(UserDB userDB) throws IOException {

        for(int i = 0; i < 3; i++) {
            User user = GUI.readLoginAndPassword();
            User userFromDB = userDB.findUserByLogin(user.getLogin());

            if(userFromDB != null &&
                    userFromDB.equals(user)) {
                Authenticator.loggedUser = userFromDB;
                return true;
            }
        }
        return false;
    }
}
