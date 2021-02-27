package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductManager() {
    }

    public void add(Product item) {
        repository.save(item);
    }

    public Product[] searchBy(String text) {
        String textLowerCase = text.toLowerCase();
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (product.matches(textLowerCase)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }



    public void removeById(int id) {
        repository.removeById(id);
    }

}

