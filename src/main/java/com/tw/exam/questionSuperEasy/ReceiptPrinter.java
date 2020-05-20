package com.tw.exam.questionSuperEasy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>This class is used to calculate the total price of the products bought.</p>
 * <p>Each products contains an <code>id</code>, which will be printed on the box. The
 * {@link ReceiptPrinter} will scan the ids of the products and give the total price
 * of the selected products.</p>
 *
 * @implNote Please read the test cases carefully and get the basic idea of the code.
 * Then please implement the correspond sections of the class to accomplish
 * the requirement.
 */
public class ReceiptPrinter {
    private final Map<String, Product> products = new HashMap<>();

    public ReceiptPrinter(List<Product> products) {
        // TODO: please implement the constructor
        // <-start-
        for (Product product : products) {
            this.products.put(product.getId(), product);
        }
        // --end-->
    }

    public int getTotalPrice(List<String> selectedProductIds) {
        // TODO: please implement the method
        // <-start-
        if (selectedProductIds == null) {
            throw new IllegalArgumentException();
        }

        int sum = 0;
        for (String selectedProductId : selectedProductIds) {
            Product product = products.get(selectedProductId);
            if (product != null) {
                sum += product.getPrice();
            }
        }
        return sum;
        // --end-->
    }
}
