package fr.as.dao;

import java.util.List;

import fr.as.models.User;

public interface IUserDAO {

    public void addUser(User u);
    public void deleteUser(User u);
    public List<User> listUsers();
    public String findPassword(String mail);

}