package com.maiyon.service;

import com.maiyon.model.dto.CheckoutInformation;
import com.maiyon.model.entity.ShoppingCart;
import com.maiyon.model.entity.User;

import java.util.List;

public interface ShoppingCartService {
    List<ShoppingCart> findAllByUser(User user);
    ShoppingCart findByShoppingCartId(Long shoppingCartId);
    ShoppingCart findByUserAndShoppingCartId(User user, Long shoppingCartId);
    ShoppingCart save(ShoppingCart shoppingCart);
    void updateOrderQuantity(Long shoppingCartId, Integer quantity);
    void deleteByUser(User user);
    void deleteByUserAndShoppingCartId(User user, Long shoppingCartId);
    void checkOut(CheckoutInformation checkoutInformation);
}
