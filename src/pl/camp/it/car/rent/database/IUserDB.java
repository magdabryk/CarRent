package pl.camp.it.car.rent.database;

import pl.camp.it.car.rent.model.User;

import java.util.List;

public interface IUserDB {
    public void presistToFile();
    public User findUserByLogin(String login);
    public List<User> getUsers();
}
