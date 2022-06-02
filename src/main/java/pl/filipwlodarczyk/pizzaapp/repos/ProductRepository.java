package pl.filipwlodarczyk.pizzaapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.filipwlodarczyk.pizzaapp.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
