package pl.filipwlodarczyk.pizzaapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private float price;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;



    public Product(String name, Float price) {
        this.productName = name;
        this.price = price;
    }

    public Product() {
    }
}
