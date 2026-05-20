package com.example.demo_lektion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("unit")
public class CalculatorTests {
    private final Calculator calc = new Calculator();

    @Test
    @DisplayName("adds two positive numbers")
    void add_positiveNumbers() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    @DisplayName("subtracts two numbers")
    void subtract_twoNumbers() {
        assertEquals(1, calc.sub(4, 3));
    }

    @Test
    @DisplayName("multiplies two numbers")
    void multiply_twoNumbers() {
        assertEquals(12, calc.mul(3, 4));
    }

    @Test
    @DisplayName("divides two numbers")
    void divide_twoNumbers() {
        assertEquals(2, calc.div(10, 5));
    }

    @Test
    @DisplayName("throws when dividing by zero")
    void divide_byZero_throws() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> calc.div(10, 0)
        );
        assertEquals("Cannot divide by zero", ex.getMessage());
    }
}
