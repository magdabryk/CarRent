package pl.camp.it.car.rent.database;

import pl.camp.it.car.rent.model.User;


import java.io.*;
import java.util.*;

public class UserDB implements IUserDB{
    private final Map<String, User> users = new HashMap<>();
    private final String USER_DB_FILE = "users.txt";

    private static final UserDB instance = new UserDB();  // nie da się stworzyć drugiego obiektu

    private UserDB() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(USER_DB_FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] params = line.split(";");
                this.users.put(params[0], new User(params[0], params[1], User.Role.valueOf(params[2])));
            }
        } catch (IOException e) {
            System.out.println("bład odczyt z pliku");
        }
    }

    public List<User> getUsers() {
        return new ArrayList<>(users.values());

    }

    public User findUserByLogin(String login) {
        return this.users.get(login);

    }

    public void presistToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.USER_DB_FILE));

            boolean flag = false;
            for (User user : this.users.values()) {
                if (flag) {
                    writer.newLine();
                }
                writer.write(user.convertToData());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("bład podczas zapisu");
            e.printStackTrace();
        }
    }

        public static UserDB getInstance(){
            return instance;
        }
        }

