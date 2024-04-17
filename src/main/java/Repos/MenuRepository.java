package Repos;

import Model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer> {
    @Query("SELECT * FROM restaurant_menus WHERE restaurant_id = ?")
    List<Menu> findMenusById(int restaurant_id);
}
