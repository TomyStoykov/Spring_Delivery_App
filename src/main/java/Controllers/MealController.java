package Controllers;

import Model.Meal;
import Services.MealService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/meals")
public class MealController {
    private MealService mealService;

    public ResponseEntity<List<Meal>> getMealsBySectionId(int sectionId){
        List<Meal> meals = mealService.getMealsBySection(sectionId);
        return ResponseEntity.ok(meals);
    }

    @PostMapping
    public ResponseEntity<Meal> createMeal(@Valid @RequestBody Meal meal){
        Meal savedMeal = mealService.createMeal(meal);
        URI location = URI.create(String.format("/api/v1/meals/%s",savedMeal.getId()));
        return ResponseEntity.created(location).body(savedMeal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMeal(@PathVariable int id){
        mealService.deleteMealById(id);
        return ResponseEntity.ok().build();
    }
}
