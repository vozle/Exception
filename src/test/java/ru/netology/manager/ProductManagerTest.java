package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Product first = new Product(1, "Garlic", 1000);
    private Book second = new Book(2, "War & Peace", 500, "L.Tolstoy");
    private Smartphone third = new Smartphone(3, "C-65", 10000, "Siemens");

    @Test
    void shouldAdd() {
        manager.add(first);
        manager.add(second);
        manager.add(third);

        Product[] actual = repository.findAll();
        Product[] expected = {first, second, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByProduct() {
        manager.add(third);
        manager.add(first);

        Product[] actual = manager.searchBy("Garlic");
        Product[] expected = {first};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBook() {
        manager.add(second);
        manager.add(first);

        Product[] actual = manager.searchBy("War");
        Product[] expected = {second};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphone() {
        manager.add(third);
        manager.add(first);

        Product[] actual = manager.searchBy("C-65");
        Product[] expected = {third};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNone() {
        Product[] actual = manager.searchBy("Cheremsha");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }
}