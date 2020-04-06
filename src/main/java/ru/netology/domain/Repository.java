package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repository {

    Product[] products = {
            new Book(1, "name1", 100, "author1"),
            new Book(2, "name2", 200, "author2"),
            new Book(3, "name3", 300, "author3"),
            new Book(4, "name4", 400, "author4"),
            new Smartphone(5, "name5", 500, "manufacturer5"),
            new Smartphone(6, "name6", 600, "manufacturer6"),
            new Smartphone(7, "name7", 700, "manufacturer7"),
            new Smartphone(8, "name8", 800, "manufacturer8"),
    };

    Product[] findAll() {
        return products;
    }

    public Product findById(int idToFind) {
        for (Product product : products) {
            if (product.getId() == idToFind) {
                return product;
            }
        }
        return null;
    }

    void save(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;
    }

    void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found.");
        } else {
            int length = products.length - 1;
            Product[] tmp = new Product[length];
            int index = 0;
            for (Product product : products) {
                if (product.getId() != id) {
                    tmp[index] = product;
                    index++;
                }
            }
            products = tmp;
        }
    }
}
