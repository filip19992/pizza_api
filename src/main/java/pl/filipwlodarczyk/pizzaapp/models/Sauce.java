package pl.filipwlodarczyk.pizzaapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import pl.filipwlodarczyk.pizzaapp.models.Product;

@Entity
@Getter
@Setter
public class Sauce extends Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private float price;
}
