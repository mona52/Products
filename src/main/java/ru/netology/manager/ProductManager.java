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
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {

        String searchLowerCase = search.toLowerCase();

        if (product instanceof Book) {
            Book book = (Book) product;
            String bookLowerCase = book.getName().toLowerCase();
            String authorLowerCase = book.getAuthor().toLowerCase();

            if (bookLowerCase.contains(searchLowerCase)) {
                return true;
            }
            if (authorLowerCase.contains(searchLowerCase)) {
                return true;
            }
        }

        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            String smartphoneLowerCase = smartphone.getName().toLowerCase();
            String producerLowerCase = smartphone.getProducer().toLowerCase();

            if (smartphoneLowerCase.contains(searchLowerCase)) {
                return true;
            }
            if (producerLowerCase.contains(searchLowerCase)) {
                return true;
            }
        }
        return false;
    }


    public void removeById(int id) {
        repository.removeById(id);
    }

}

