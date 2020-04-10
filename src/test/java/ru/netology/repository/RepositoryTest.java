package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RepositoryTest {

    ProductRepository repository = new ProductRepository();

    @Test
    void shouldFindAll() {
        Product[] actual = repository.findAll();
        Product[] expected = {
                new Book(1, "name1", 100, "author1"),
                new Book(2, "name2", 200, "author2"),
                new Book(3, "name3", 300, "author3"),
                new Book(4, "name4", 400, "author4"),
                new Smartphone(5, "name5", 500, "manufacturer5"),
                new Smartphone(6, "name6", 600, "manufacturer6"),
                new Smartphone(7, "name7", 700, "manufacturer7"),
                new Smartphone(8, "name8", 800, "manufacturer8"),
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSave() {
        Product productToSave = new Book(9, "name9", 900, "author9");
        repository.save(productToSave);
        Product[] actual = repository.findAll();
        Product[] expected = {
                new Book(1, "name1", 100, "author1"),
                new Book(2, "name2", 200, "author2"),
                new Book(3, "name3", 300, "author3"),
                new Book(4, "name4", 400, "author4"),
                new Smartphone(5, "name5", 500, "manufacturer5"),
                new Smartphone(6, "name6", 600, "manufacturer6"),
                new Smartphone(7, "name7", 700, "manufacturer7"),
                new Smartphone(8, "name8", 800, "manufacturer8"),
                new Book(9, "name9", 900, "author9"),
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByExistingId() {
        repository.removeById(3);
        Product[] actual = repository.findAll();
        Product[] expected = {
                new Book(1, "name1", 100, "author1"),
                new Book(2, "name2", 200, "author2"),
                new Book(4, "name4", 400, "author4"),
                new Smartphone(5, "name5", 500, "manufacturer5"),
                new Smartphone(6, "name6", 600, "manufacturer6"),
                new Smartphone(7, "name7", 700, "manufacturer7"),
                new Smartphone(8, "name8", 800, "manufacturer8"),
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByNotExistingId() {
        ProductRepository repository = new ProductRepository();
        assertThrows(NotFoundException.class, () -> repository.removeById(15));
    }
}
