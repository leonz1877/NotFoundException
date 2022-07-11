package ru.netology.repository;

import ru.netology.exception.NotFoundException;
import ru.netology.product.Product;

public class ProductRepository {

    private Product[] items = new Product[0];

    public void save (Product item) {
        Product[] temp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            temp[i] = items[i];
        }
        temp[temp.length - 1] = item;
        items = temp;

    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById (int id) {

        if (findById(id) != null){
            Product[] temp = new  Product[items.length - 1];
            int index = 0;
            for (Product item  : items){
                if (item.getId() != id) {
                    temp[index] = item;
                    index++;
                }
            }
            items = temp;
        }
        else {
            throw new NotFoundException("Товар с id " +id + " не найден");
        }

    }

    public Product[] findAll() {
        return items;
    }
}