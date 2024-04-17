package Services;

import Model.Cart;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public class CartService {
    @Autowired
    private Cart cart;
    public double getCartTotal(){
        return cart.getTotalPrice();
    }
}
