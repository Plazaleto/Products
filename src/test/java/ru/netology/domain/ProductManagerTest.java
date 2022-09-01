package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product product1 = new Book(1, "A", 40, "AAA");
    Product product2 = new Book(2, "B", 50, "BBB");
    Product product3 = new Smartphone(3, "Samsung", 5_000, "삼성");
    Product product4 = new Smartphone(4, "Iphone", 6_000, "Apple Inc.");
    Product product5 = new Smartphone(4, "Iphone", 6_000, "Apple Inc.");


    @BeforeEach
    public void shouldAddProduct() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
    }


    @Test
    public void shouldFindOneProductByName() {
        Product[] expected = {product1};
        Product[] actual = manager.searchBy("A");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMoreThanOneProductByName() {
        Product[] expected = {product4, product5};
        Product[] actual = manager.searchBy("Iphone");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNothingByName() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Синхрофазатрон");

        Assertions.assertArrayEquals(expected, actual);


    }

}
