package Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotBlank
    @Email
    @Column(unique = true)
    @Size(max = 255)
    private String email;

    @NotBlank
    @Lob
    private String hashedPassword;

    @Lob
    private String address;

    @NotBlank
    @Size(max = 255)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role = Role.CUSTOMER;

    @Lob
    private byte[] salt;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;

    public enum Role {
        CUSTOMER, RESTAURANT_OWNER, ADMIN
    }
}
