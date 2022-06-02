package pl.filipwlodarczyk.pizzaapp.services;

import org.springframework.stereotype.Service;
import pl.filipwlodarczyk.pizzaapp.models.Pizza;
import pl.filipwlodarczyk.pizzaapp.repos.PizzaRepository;

import java.util.*;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepo;



    public PizzaService(PizzaRepository pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }

    public Optional<Pizza> getPizzaById(long id) {
        return pizzaRepo.findById(id);
    }

    public List<Pizza> getEveryPizza() {
        return pizzaRepo.findAll();
    }

    public void savePizza(Pizza pizza){
        pizzaRepo.save(new Pizza(pizza.getProductName(), List.of(pizza.getIngredients()), pizza.getDescription(), pizza.getImageUrl(), pizza.getPrice()));
    }

    public Optional<Pizza> getCheapestPizza() {

        return getAllPizzas()
                .stream()
                .min(Comparator.comparing(Pizza::getPrice));
    }

    //TODO:Test it with PostMan :)
    public void setPizzaName(String oldName, String newName) {
        Optional<Pizza> foundPizza = getAllPizzas()
                .stream()
                .filter(pizza -> pizza.getProductName().equals(oldName))
                .findAny();

        if(foundPizza.isPresent()){
            Pizza pizza = foundPizza.get();

            pizza.setProductName(newName);
        }
    }

    private List<Pizza> getAllPizzas() {
        return pizzaRepo.findAll();
    }
}
