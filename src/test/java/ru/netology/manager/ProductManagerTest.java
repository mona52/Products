package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Product book1 = new Book(1, "Book1", 50, "Orange");
    private Product book2 = new Book(2, "book2", 100, "Apple");
    private Product smartphone1 = new Smartphone(3, "smartphone orange", 50000, "apple");
    private Product smartphone2 = new Smartphone(4, "smartphone like book", 5000, "samsung");


        @BeforeEach
        public void setUp() {
            manager.add(book1);
            manager.add(book2);
            manager.add(smartphone1);
            manager.add(smartphone2);
        }


    @Test // поиск всех продуктов с символами "book" в любом регистре
    void searchByAllBookLowerCase() {
        Product[] actual = manager.searchBy("book");
        Product[] expected = new Product[]{book1, book2, smartphone2};
        assertArrayEquals(expected, actual);
    }

    @Test // поиск всех продуктов с символами "BOOK" в любом регистре
    void searchByAllBookUpCase() {
        Product[] actual = manager.searchBy("BOOK");
        Product[] expected = new Product[]{book1, book2, smartphone2};
        assertArrayEquals(expected, actual);
    }
    @Test // поиск всех продуктов с символами "orange" в любом регистре
    void searchByAllOrange() {
        Product[] actual = manager.searchBy("orange");
        Product[] expected = new Product[]{book1, smartphone1};
        assertArrayEquals(expected, actual);
    }

    @Test // поиск всех продуктов с символами "APPLE" в любом регистре
    void searchByAllApple() {
        Product[] actual = manager.searchBy("APPLE");
        Product[] expected = new Product[]{book2, smartphone1};
        assertArrayEquals(expected, actual);
    }

    @Test // поиск всех продуктов с символами "smartphone" в любом регистре
    void searchByAllSmartphones() {
        Product[] actual = manager.searchBy("smartphone");
        Product[] expected = new Product[]{smartphone1, smartphone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void matchesBook() {
        boolean actual = book1.matches("book");
        boolean expected = true;
        assertEquals(actual, expected);
    }

    @Test
    void noMatchesBook() {
        boolean actual = book2.matches("aaaa");
        boolean expected = false;
        assertEquals(actual, expected);
    }

    @Test
    void matchesSmartphones() {
        boolean actual = smartphone1.matches("Smartphone");
        boolean expected = true;
        assertEquals(actual, expected);
    }

    @Test
    void noMatchesSmartphones() {
        boolean actual = smartphone2.matches("uuuuuuUU");
        boolean expected = false;
        assertEquals(actual, expected);
    }
}