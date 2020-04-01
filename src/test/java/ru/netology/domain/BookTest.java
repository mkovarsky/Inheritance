package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {

    @Test
    void ShouldMatchByName() {
        Book book = new Book(3, "name3", 300, "author3");
        boolean actual = true;
        boolean expected = book.matches("name3");
        assertEquals(actual, expected);
    }

    @Test
    void ShouldMatchByAuthor() {
        Book book = new Book(2, "name2", 200, "author2");
        boolean actual = true;
        boolean expected = book.matches("author2");
        assertEquals(actual, expected);
    }

    @Test
    void ShouldNotMatchByNotExistedValue() {
        Book book = new Book(1, "name1", 100, "author1");
        boolean actual = false;
        boolean expected = book.matches("955%");
        assertEquals(actual, expected);
    }
}
