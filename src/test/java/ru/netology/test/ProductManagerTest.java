package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.exception.NotFoundException;
import ru.netology.manager.ProductManager;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
        Product item1 = new Book(11, "Красная таблетка", 1_399, "Курпатов");
        Product item2 = new Book(22, "Властелин колец", 2_999, "Толкиен");
        Product item3 = new Book(33, "Бойцовский клуб", 1_699, "Паланик");
        Product item4 = new Book(44, "12 негритят", 299, "Кристи");
        Product item5 = new Smartphone(515, "Bison", 8_999, "Umidigi");
        Product item6 = new Smartphone(626, "OnePlus", 38_999, "OnePlus");
        Product item7 = new Smartphone(737, "Iphone 12 mini", 32_999, "Apple");
        Product item8 = new Smartphone(848, "Iphone 12", 42_999, "Apple");

    //Удалить 1 товар
    @Test
    public void delByIdOneItem () {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);
        manager.delById(515);

        Product[] expected = {
                item1,
                item2,
                item3,
                item4,
                //item5,
                item6,
                item7,
                item8
        };
        Product[] actual = manager.watch();

        Assertions.assertArrayEquals(expected, actual);

    }

    //Удалить товар с несуществующим id
    @Test
    public void delByIdNotExistItem () {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);

        Assertions.assertThrows(NotFoundException.class, () -> {
           manager.delById(-222);
        });
    }
}
