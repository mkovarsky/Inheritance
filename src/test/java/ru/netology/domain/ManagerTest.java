package ru.netology.domain;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    Repository repository = new Repository();
    Manager manager = new Manager(repository);

    @Test
    void ShouldAddProductToRepository() {
        Product productToAdd = new Book(9, "name9", 900, "author9");
        manager.addProductToRepository(productToAdd);
        Product[] actual = manager.searchBy("name9");
        Product[] expected = {new Smartphone(9, "name9", 900, "author9")};
    }

    @Test
    void ShouldSearchBookByName() {
        Product[] actual = manager.searchBy("name1");
        Product[] expected = {new Book(1, "name1", 100, "author1")};
        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldSearchSmartphoneByName() {
        Product[] actual = manager.searchBy("name6");
        Product[] expected = {new Smartphone(6, "name6", 600, "manufacturer6")};
        assertArrayEquals(expected, actual);
    }
    @Test
    void ShouldSearchBookByAuthor() {
        Product[] actual = manager.searchBy("author2");
        Product[] expected = {new Book(2, "name2", 200, "author2")};
        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldSearchSmartphoneByManufacturer() {
        Product[] actual = manager.searchBy("manufacturer5");
        Product[] expected = {new Smartphone(5, "name5", 500, "manufacturer5")};
        assertArrayEquals(expected, actual);
    }
    @Test
    void ShouldNotSearchByNotExistedValue() {
        Product[] actual = manager.searchBy("@9999");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }
}
