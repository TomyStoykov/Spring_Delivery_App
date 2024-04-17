package Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "menu_sections")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_sections")
    private int id;

    @Column(name = "menu_id")
    private int menu_id;

    @NotBlank
    @Column(name = "sectionName")
    @Size(max = 255)
    private String name;

    @ManyToOne
    @JoinColumn(updatable = false, insertable = false)
    private Menu menu;
}
