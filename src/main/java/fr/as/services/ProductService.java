package fr.as.services;

import fr.as.dao.IProductDAO;
import fr.as.models.Product;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@ManagedBean(name="productService")
@SessionScoped
public class ProductService implements IProductService {

    private IProductDAO productDAO;
    private String name;
    private String price;

    public void setProductDAO(IProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Transactional
    public void addProduct(Product u) {
        this.productDAO.addProduct(u);
    }

    @Transactional
    public void deleteProduct(Product u) {
        this.productDAO.deleteProduct(u);
    }

    @Transactional
    public List<Product> listProducts() {
        return this.productDAO.listProducts();
    }


    public String gotoLog(){
        return "success";
    }

    public String gotoWelcomePage() {
        return "failure";
    }
}
