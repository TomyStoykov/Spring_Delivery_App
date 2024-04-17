package Services;

import Model.Cart;
import Model.CartItem;
import Model.Order;
import Model.OrderDetail;
import Repos.OrderDetailRepository;
import Repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private CartService cartService;

    public List<Order> getAllUserOrders(int user_id){
        return orderRepository.getOrdersByUserId(user_id);
    }

    public int saveOrder(Cart cart, int userId, int restaurantId) {
        Order order = new Order();
        order.setUser_id(userId);
        order.setRestaurant_id(restaurantId);
        order.setOrderTotal(cart.getTotalPrice());

        order = orderRepository.save(order);

        for (CartItem item : cart.getItems()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder_id(order.getId());
            orderDetail.setItem_id(item.getMeal().getId());
            orderDetail.setQuantity(item.getQuantity());
            orderDetail.setPrice(item.getMeal().getPrice());

            orderDetailRepository.save(orderDetail);
        }

        return order.getId();
    }
}
