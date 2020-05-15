package com.tw.exam.questionSuperEasy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptPrinterTest {
    static final List<Product> products = Arrays.asList(
            new Product("BAX003", "Coca Cola", 3),
            new Product("BAX021", "Coca Cola", 4),
            new Product("BAX303", "Coca Cola", 2)
    );

    @Test
    void should_calculate_total_prices() {
        final ReceiptPrinter printer = new ReceiptPrinter(products);
        final int totalPrice = printer.getTotalPrice(Arrays.asList("BAX003", "BAX021"));
        assertEquals(7, totalPrice);
    }

    @Test
    void should_calculate_total_prices_when_select_duplicated_products() {
        final ReceiptPrinter printer = new ReceiptPrinter(products);
        final int totalPrice = printer.getTotalPrice(Arrays.asList("BAX003", "BAX021", "BAX003"));
        assertEquals(10, totalPrice);
    }

    @Test
    void should_calculate_total_prices_when_select_none() {
        final ReceiptPrinter printer = new ReceiptPrinter(products);
        final int totalPrice = printer.getTotalPrice(Collections.emptyList());
        assertEquals(0, totalPrice);
    }

    @Test
    void should_throw_if_selected_product_is_null() {
        final ReceiptPrinter printer = new ReceiptPrinter(products);
        assertThrows(IllegalArgumentException.class, () -> printer.getTotalPrice(null));
    }
}