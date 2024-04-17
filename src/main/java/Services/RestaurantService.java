package Services;

import Model.Menu;
import Model.Restaurant;
import Repos.MenuRepository;
import Repos.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private MenuRepository menuRepository;

    public List<Restaurant> getAllRestaurants(){
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestaurantById(int restaurant_id){
        return restaurantRepository.findById(restaurant_id);
    }
    public List<Menu> getMenusByRestaurant(int restaurant_id){
        return menuRepository.findMenusById(restaurant_id);
    }

    public Optional<Restaurant> getRestaurantByName(String restaurant_name){
        return Optional.ofNullable(restaurantRepository.findByName(restaurant_name));
    }

    public Restaurant createRestaurant(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    public void deleteRestaurantById(int restaurant_id){
        Optional<Restaurant> restaurant = getRestaurantById(restaurant_id);
        restaurantRepository.delete(restaurant);
    }

    public void deleteRestaurantMenu(int restaurant_id, String menuName) {
        Optional<Restaurant> optionalRestaurant = getRestaurantById(restaurant_id);
        if (optionalRestaurant.isPresent()) {
            List<Menu> menus = getMenusByRestaurant(restaurant_id);
            menus.removeIf(menu -> menu.getMenuName().equals(menuName));
            menuRepository.saveAll(menus);
        }
    }
}
