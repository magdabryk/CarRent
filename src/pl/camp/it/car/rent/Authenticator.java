package pl.camp.it.car.rent;
import pl.camp.it.car.rent.database.IUserDB;
import pl.camp.it.car.rent.database.UserDB;
import pl.camp.it.car.rent.gui.GUI;
import pl.camp.it.car.rent.model.User;


import java.io.IOException;

public class Authenticator {
    public static String seed = "1Tl8*G3Ertpxvj0%8qpy";
    public static User loggedUser;
    
    private static final Authenticator instance = new Authenticator();

    public Authenticator() {
    }

    public static boolean authenticate() throws IOException {
        IUserDB userDB = UserDB.getInstance();
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
    public static Authenticator getInstance(){
        return instance;
    }
}
