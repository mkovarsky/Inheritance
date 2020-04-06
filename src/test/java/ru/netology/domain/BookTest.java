package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {

    @Test
    void shouldMatchByName() {
        Book book = new Book(3, "name3", 300, "author3");
        boolean actual = book.matches("name3");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void shouldMatchByAuthor() {
        Book book = new Book(2, "name2", 200, "author2");
        boolean actual = book.matches("author2");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotMatchByNotExistedValue() {
        Book book = new Book(1, "name1", 100, "author1");
        boolean actual = book.matches("955%");
        boolean expected = false;
        assertEquals(expected, actual);
    }
}
