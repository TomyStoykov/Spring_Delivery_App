package Repos;

import Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    Restaurant findByName(String name);

    List<Restaurant>findAll();

    void delete(Optional<Restaurant> restaurant);

    void deleteById(Integer restaurantId);
}

