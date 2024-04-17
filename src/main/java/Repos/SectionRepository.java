package Repos;

import Model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section,Integer> {
    Section findByName(String section_name);

    List<Section> findAll();

    @Query("SELECT * FROM menu_sections WHERE menu_id = ?")
    Section getSectionsByMenuId(int menu_id);

    @Query("SELECT section_id FROM menu_sections WHERE sectionName = ?")
    Section getSectionIdByName(String sectionName);
}
