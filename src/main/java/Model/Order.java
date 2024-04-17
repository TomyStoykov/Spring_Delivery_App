package Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "column_id")
    private int id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "restaurant_id")
    private int restaurant_id;

    @Column(name = "order_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;
    public enum Status{
        PENDING,DELIVERED,CANCELLED,SHIPPING
    }

    @Column(name = "orderTotal")
    private double orderTotal;

    @OneToMany
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private User user;

    @OneToMany
    @JoinColumn(name = "restaurant_id",insertable = false,updatable = false)
    private Restaurant restaurant;

}
