package pl.filipwlodarczyk.pizzaapp.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import pl.filipwlodarczyk.pizzaapp.models.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Pizza extends Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ingredients;
    private String description;
    private String imageUrl;

    public Pizza() {
    }

    public Pizza(String name, List<String> ingredients, String description, String imageUrl, Float price) {
        super(name, price);
        GsonBuilder builder = new GsonBuilder();

        Gson gson = builder.create();

        String jsonIngredients = gson.toJson(ingredients);


        this.ingredients = jsonIngredients;
        this.description = description;
        this.imageUrl = imageUrl;
    }


    public void setIngredients(ArrayList<String> ingredients) {
        GsonBuilder builder = new GsonBuilder();

        Gson gson = builder.create();

        String jsonIngredients = gson.toJson(ingredients);
        this.ingredients = jsonIngredients;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "ingredients=" + ingredients +
                '}';
    }
}
