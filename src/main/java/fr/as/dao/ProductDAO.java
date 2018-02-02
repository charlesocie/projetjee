package fr.as.dao;

import fr.as.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

public class ProductDAO implements IProductDAO {

    private static final Logger logger = LoggerFactory.getLogger(ProductDAO.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @SuppressWarnings("unchecked")
    public void addProduct(Product p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Product saved successfully, Product Details="+p);
    }

    @SuppressWarnings("unchecked")
    public void deleteProduct(Product p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(p);
        logger.info("Product delete successfully, Product Details="+p);
    }

    public List<Product> listProducts() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Product> ProductsList = session.createQuery("from Product").list();
        for(Product u : ProductsList){
            logger.info("Product List::"+u);
        }
        return ProductsList;
    }
}
