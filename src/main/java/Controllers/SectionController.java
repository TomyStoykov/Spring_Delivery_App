package Controllers;

import Model.Section;
import Services.SectionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sections")
public class SectionController {
    @Autowired
    private SectionService sectionService;

    @GetMapping("/menu/{menu_id}")
    public ResponseEntity<List<Section>> getSectionsByMenuId(@PathVariable int menuId){
        List<Section> sections = sectionService.displaySectionForMenu(menuId);
        return ResponseEntity.ok(sections);
    }

    @PostMapping
    public ResponseEntity<Section> createSection(@Valid @RequestBody Section section){
        Section savedSection = sectionService.createSection(section);
        URI location = URI.create(String.format("/api/v1/sections/%s", savedSection.getId()));
        return ResponseEntity.created(location).body(savedSection);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<?> deleteSection(@PathVariable int id){
        if (!sectionService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        sectionService.deleteSection(id);
        return ResponseEntity.ok().build();
    }
}
