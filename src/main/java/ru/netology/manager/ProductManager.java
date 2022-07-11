package ru.netology.manager;

import ru.netology.product.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add (Product item) {
        repository.save(item);
    }

    public void delById (int id) {
        repository.removeById(id);
    }

    public Product [] watch () {
        return repository.findAll();
    }

    public Product [] searchBy(String text) {
        Product[] result = new Product[0];
        //int index = 0;

        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] temp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++ ) {
                    temp[i] = result[i];
                }
                temp[temp.length - 1] = product;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}