package fr.as.services;

import fr.as.models.Product;

import java.util.List;

public interface IProductService {
    public void addProduct(Product u);
    public void deleteProduct(Product u);
    public List<Product> listProducts();
    public String gotoLog();
    public String gotoWelcomePage();
}
