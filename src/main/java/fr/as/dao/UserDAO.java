package fr.as.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import fr.as.models.User;

@Repository
public class UserDAO implements IUserDAO{

    private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    public void addUser(User u) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(u);
        logger.info("User saved successfully, User Details="+u);
    }

    public void deleteUser(User u) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(u);
        logger.info("User delete successfully, User Details="+u);
    }

    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> UsersList = session.createQuery("from User").list();
        for(User u : UsersList){
            logger.info("User List::"+u);
        }
        return UsersList;
    }

    @SuppressWarnings("unchecked")
    public String findPassword(String mail) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            List<User> UsersList = session.createQuery("from User").list();
            for (User u : UsersList) {
                logger.info("User List::" + u);
            }
            int i = 0;
            while (i < UsersList.size() && !mail.equals(UsersList.get(i).getMail())) {
                i++;
            }
            return UsersList.get(i).getPassword();
        }
        catch (Exception e){
            return "failure";
        }
    }

}
