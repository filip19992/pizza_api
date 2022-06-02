package pl.filipwlodarczyk.pizzaapp.services;

import org.springframework.stereotype.Service;
import pl.filipwlodarczyk.pizzaapp.models.Product;
import pl.filipwlodarczyk.pizzaapp.repos.ProductRepository;

@Service
       // !!!!!!!!!!!!!!!!!!!USED TO EVERY PRODUCT(SAUCE, DRINKS ETC) EXCEPT PIZZA!!!!!!!!!!!!!!!!!!!
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
