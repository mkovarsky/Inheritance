package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test
    void ShouldMatchByName() {
        Smartphone smartphone = new Smartphone(5, "name5", 500, "manufacturer5");
        boolean actual = true;
        boolean expected = smartphone.matches("name5");
        assertEquals(actual, expected);
    }

    @Test
    void ShouldMatchByManufacturer() {
        Smartphone smartphone = new Smartphone(6, "name6", 600, "manufacturer6");
        boolean actual = true;
        boolean expected = smartphone.matches("manufacturer6");
        assertEquals(actual, expected);
    }

    @Test
    void ShouldNotMatchByNotExistedValue() {
        Smartphone smartphone = new Smartphone(7, "name7", 700, "manufacturer7");
        boolean actual = false;
        boolean expected = smartphone.matches("@44");
        assertEquals(actual, expected);
    }
}