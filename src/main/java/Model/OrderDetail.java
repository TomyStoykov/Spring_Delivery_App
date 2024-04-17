package Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_details")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderDetails_id")
    private int id;

    @Column(name = "order_id")
    private int order_id;

    @Column(name = "item_id")
    private int item_id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @OneToOne
    @JoinColumn(name = "orders",insertable = false,updatable = false)
    private Order order;

    @OneToOne
    @JoinColumn(name = "menu_items",insertable = false,updatable = false)
    private Meal meal;
}
