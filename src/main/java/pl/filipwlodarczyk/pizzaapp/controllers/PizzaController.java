package pl.filipwlodarczyk.pizzaapp.controllers;

import org.springframework.web.bind.annotation.*;
import pl.filipwlodarczyk.pizzaapp.models.Pizza;
import pl.filipwlodarczyk.pizzaapp.services.PizzaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }


    @GetMapping("/{id}")
    public Optional<Pizza> getPizzaById(@PathVariable long id) {
        return pizzaService.getPizzaById(id);
    }

    @GetMapping("/all")
    public List<Pizza> getAllPizza() {
        return pizzaService.getEveryPizza();
    }

    @PutMapping("/savePizza")
    public void savePiza(@RequestBody Pizza pizza) {
        pizzaService.savePizza(pizza);
    }

    @GetMapping("/cheapest-pizza")
    public Optional<Pizza> getCheapestPizza() {
        return pizzaService.getCheapestPizza();
    }

    @PostMapping
    public void setPizzaName(@RequestBody String oldName, String newName) {
      pizzaService.setPizzaName(oldName,newName);
    }


}
