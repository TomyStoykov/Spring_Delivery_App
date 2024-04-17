package Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "menu_items")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int id;

    @Column(name = "section_id")
    private int section_id;

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotNull
    private double price;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "section_id",insertable = false,updatable = false)
    private Section section;




}
