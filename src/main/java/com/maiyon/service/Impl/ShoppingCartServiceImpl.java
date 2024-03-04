package com.maiyon.service.Impl;

import com.maiyon.model.dto.CheckoutInformation;
import com.maiyon.model.entity.ShoppingCart;
import com.maiyon.model.entity.User;
import com.maiyon.repository.ShoppingCartRepository;
import com.maiyon.service.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final InvoiceService invoiceService;
    private final InvoiceDetailService invoiceDetailService;
    @Override
    public List<ShoppingCart> findAllByUser(User user) {
        return shoppingCartRepository.findAllByUser(user);
    }

    @Override
    public ShoppingCart findByShoppingCartId(Long shoppingCartId) {
        return shoppingCartRepository.findById(shoppingCartId).orElse(null);
    }

    @Override
    public ShoppingCart findByUserAndShoppingCartId(User user, Long shoppingCartId) {
        return shoppingCartRepository.findByShoppingCartIdAndUser(shoppingCartId, user);
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void updateOrderQuantity(Long shoppingCartId, Integer quantity) {
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(shoppingCartId);
        if (shoppingCart.isPresent()){
            ShoppingCart updateCart = shoppingCart.get();
            updateCart.setOrderQuantity(quantity);
            shoppingCartRepository.save(updateCart);
        }
    }

    @Override
    public void deleteByUser(User user) {
        shoppingCartRepository.deleteByUser(user);
    }

    @Transactional
    @Override
    public void deleteByUserAndShoppingCartId(User user, Long shoppingCartId) {
        shoppingCartRepository.deleteShoppingCartByShoppingCartIdAndUser(shoppingCartId, user);
    }

    @Transactional
    @Override
    public void checkOut(CheckoutInformation checkoutInformation) {

    }
}