package pl.filipwlodarczyk.pizzaapp.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
@Entity
@Getter
@Table
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @OneToMany(mappedBy = "order")
    private List<Product> products;

    private float totalPrice;

    public Order(List<Product> products) {
        this.products = products;
    }

    public Order() {
    }
}
