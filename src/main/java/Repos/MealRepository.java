package Repos;

import Model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal,Integer> {
    @Query("SELECT * FROM menu_items WHERE section_id = ?")
    List<Meal> findMealsBySectionId(int section_id);
}
