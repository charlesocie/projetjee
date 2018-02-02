package fr.as.dao;

import fr.as.models.Product;

import java.util.List;

public interface IProductDAO {
    public void addProduct(Product u);
    public void deleteProduct(Product u);
    public List<Product> listProducts();


}
