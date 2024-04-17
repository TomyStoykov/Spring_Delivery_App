package Services;

import Model.Menu;
import Repos.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> displayMenusForRestaurant(int restaurantId) {
        List<Menu> menus = menuRepository.findMenusById(restaurantId);
        if (menus.isEmpty()) {
            System.out.println("No menus available for this restaurant at the moment.");
            return Collections.emptyList();
        }
        System.out.println("Available menus:");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getMenuName());
        }
        return menus;
    }
    public List<Menu> getMenusByRestaurant(int restaurantId){
        return menuRepository.findMenusById(restaurantId);
    }

    public Menu createMenu(Menu menu){
        return menuRepository.save(menu);
    }

    public void deleteMenu(int menu_id) {
        menuRepository.deleteById(menu_id);
    }
}

