package pl.filipwlodarczyk.pizzaapp.utils;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.filipwlodarczyk.pizzaapp.models.Pizza;
import pl.filipwlodarczyk.pizzaapp.models.Product;
import pl.filipwlodarczyk.pizzaapp.services.PizzaService;
import pl.filipwlodarczyk.pizzaapp.services.ProductService;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class DataLoader  implements ApplicationListener<ContextRefreshedEvent> {


    boolean alreadySetup = false;
    private final PizzaService pizzaService;
    private final ProductService productService;

    public DataLoader(PizzaService pizzaService, ProductService productService) {
        this.pizzaService = pizzaService;
        this.productService = productService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (alreadySetup) {
            return;
        }

        for(int i = 0; i < 10; i++) {
            pizzaService.savePizza(new Pizza("Pizza " + i,
                    new ArrayList<>(Arrays.asList("Ham", "Cheese", "Mushrooms")),
                    "Simple pizza",
                    "www.url.com",
                    i + 20F));
        }

        for(int i = 10; i < 20; i++) {
            pizzaService.savePizza(new Pizza("Pizza " + i,
                    new ArrayList<>(Arrays.asList("Ham", "Cheese", "Pineapple")),
                    "Hawaii pizza",
                    "www.url.com",
                    i+25F));
        }

        productService.saveProduct(new Product("Garlic sauce", 3.50F));
        productService.saveProduct(new Product("Spicy sauce", 3.50F));
        productService.saveProduct(new Product("Tomatoe sauce", 3.50F));




    }
}