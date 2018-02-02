package fr.as.services;

import java.util.List;

import fr.as.models.User;

public interface IUserService {

    public void addUser(User u);
    public void deleteUser(User u);
    public List<User> listUsers();
    public String gotoProd();
    public String gotoWelcomePage();
    public String findPassword(String mail, String password);

}