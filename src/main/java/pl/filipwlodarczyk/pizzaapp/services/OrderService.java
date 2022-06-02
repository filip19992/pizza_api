package pl.filipwlodarczyk.pizzaapp.services;

import org.springframework.stereotype.Service;
import pl.filipwlodarczyk.pizzaapp.models.Order;
import pl.filipwlodarczyk.pizzaapp.models.Product;
import pl.filipwlodarczyk.pizzaapp.repos.OrderRepo;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public void makeOrder(List<Product> products) {
        orderRepo.save(new Order(products));
    }
}
