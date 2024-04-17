package Services;

import Model.Section;
import Repos.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;

    public Section createSection(Section section){
        return sectionRepository.save(section);
    }

    public void deleteSection(int sectionId){
        sectionRepository.deleteById(sectionId);
    }

    public List<Section> displaySectionForMenu(int menu_id){
        List<Section>sections = (List<Section>) sectionRepository.getSectionsByMenuId(menu_id);

        if(sections.isEmpty()){
            System.out.println("No sections available for this menu at the moment.");
            return Collections.emptyList();
        }

        System.out.println("Available sections: ");
        for(int i = 0;i < sections.size();i++){
            System.out.println((i + 1) + ". " + sections.get(i).getName());
        }
        return sections;
    }

    public boolean existsById(int id) {
        return sectionRepository.existsById(id);
    }
}
