package Controllers;

import Model.Menu;
import Services.MenuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/v1/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Menu>> getMenusByRestaurant(@PathVariable int restaurantId) {
        List<Menu> menus = menuService.getMenusByRestaurant(restaurantId);
        return ResponseEntity.ok(menus);
    }
    @PostMapping
    public ResponseEntity<Menu> createMenu(@Valid @RequestBody Menu menu){
        Menu savedMenu = menuService.createMenu(menu);
        URI location = URI.create(String.format("/api/v1/menus/%s", savedMenu.getId()));
        return ResponseEntity.created(location).body(savedMenu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMenu(@PathVariable int id) {
        menuService.deleteMenu(id);
        return ResponseEntity.ok().build();
    }

}
