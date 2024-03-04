package com.maiyon.repository;

import com.maiyon.model.entity.ShoppingCart;
import com.maiyon.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    List<ShoppingCart> findAllByUser(User user);
    void deleteShoppingCartByShoppingCartIdAndUser(Long shoppingCartId, User user);
    void deleteByUser(User user);
    ShoppingCart findByShoppingCartIdAndUser(Long shoppingCartId, User user);
}
