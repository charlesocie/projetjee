package fr.as.services;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.as.dao.IUserDAO;
import fr.as.models.User;

@Service
@ManagedBean(name="userService")
@SessionScoped
public class UserService implements IUserService {

    private IUserDAO userDAO;
    private String login;
    private String password;

    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public void addUser(User p) {
        this.userDAO.addUser(p);
    }

    @Transactional
    public void deleteUser(User u) {
        this.userDAO.deleteUser(u);
    }

    @Transactional
    public List<User> listUsers() {
        return this.userDAO.listUsers();
    }

    public String gotoProd() {
        return "success";
    }

    public String gotoWelcomePage() {
        return "failure";
    }

    @Transactional
    public String findPassword(String mail, String password){
        return this.userDAO.findPassword(mail).equals(password)?"success":"failure";
    }

}
