package com.shravan.learn.amazon;

// AmazonService -> map Users, map Products, map Orders
// placeOrder(User, ShoppingCart) -> Product.updateQuantity(-quantity), add to OrderItems,
// -> createOrder, user.addOrder, cart.clear


// User -> name, email, pwd, Orders,
// addOrder

// ShoppingCart -> map OrderItems (productId -> OrderItem)
// addItem(Product, quantity)
// removeItem(productId)
// updateItemQuantity(productId, quantity)
// clear()

// Order -> id, User, OrderItems, totalAmount, OrderStatus
// OrderItem -> Product, quantity
// OrderStatus -> PENDING, PROCESSING, SHIPPED, DELIVERED, CANCELLED
// Product -> name, description, price, quantity
// updateQuantity(quantity)
// isAvailable(quantity)
public class AmazonMain {
    public static void main(String[] args) {

    }
}
