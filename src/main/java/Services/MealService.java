package Services;

import Model.Meal;
import Repos.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MealService {
    @Autowired
    MealRepository mealRepository;

    public Meal createMeal(Meal meal){
        return mealRepository.save(meal);
    }
    public void deleteMealById(int id){
        mealRepository.deleteById(id);
    }

    public List<Meal> getMealsBySection(int section_id){
        return mealRepository.findMealsBySectionId(section_id);
    }

    public List<Meal> listMeals(int section_id){
        List<Meal> meals = getMealsBySection(section_id);
        if(meals.isEmpty()){
            System.out.println("No meals available for this section right now");
            return Collections.emptyList();
        }
        for(int i = 0;i<meals.size();i++){
            System.out.println((i+1) + ". " + meals.get(i).getDescription() + " - $" + meals.get(i).getPrice());
        }
        return meals;
    }
}
