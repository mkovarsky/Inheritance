package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test
    void shouldMatchByName() {
        Smartphone smartphone = new Smartphone(5, "name5", 500, "manufacturer5");
        boolean actual = smartphone.matches("name5");
        boolean expected = true;
        assertEquals(actual, expected);
    }

    @Test
    void shouldMatchByManufacturer() {
        Smartphone smartphone = new Smartphone(6, "name6", 600, "manufacturer6");
        boolean actual = smartphone.matches("manufacturer6");
        boolean expected = true;
        assertEquals(actual, expected);
    }

    @Test
    void shouldNotMatchByNotExistedValue() {
        Smartphone smartphone = new Smartphone(7, "name7", 700, "manufacturer7");
        boolean actual = smartphone.matches("@44");
        boolean expected = false;
        assertEquals(actual, expected);
    }
}
