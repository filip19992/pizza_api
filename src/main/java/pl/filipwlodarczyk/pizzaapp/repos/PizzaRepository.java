package pl.filipwlodarczyk.pizzaapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.filipwlodarczyk.pizzaapp.models.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository <Pizza, Long> {

}
