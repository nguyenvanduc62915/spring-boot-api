package com.example.project.Utils;

import com.example.project.DTO.*;
import com.example.project.Entity.*;
import org.springframework.stereotype.Component;

@Component
public class ConvertRelationship {
    public AccountDTO convertToAccountDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(account.getAccountId());
        accountDTO.setLastName(account.getLastName());
        accountDTO.setFirstName(account.getFirstName());
        accountDTO.setEmail(account.getEmail());
        accountDTO.setImage(account.getImage());
        accountDTO.setPassword(account.getPassword());
        accountDTO.setUpdatedAt(account.getUpdatedAt());
        accountDTO.setCreatedAt(account.getCreatedAt());
        accountDTO.setAddress(account.getAddress());
        return accountDTO;
    }

    public Account convertToAccount(AccountDTO accountDTO){
        Account account = new Account();
        account.setAccountId(accountDTO.getAccountId());
        account.setLastName(accountDTO.getLastName());
        account.setFirstName(accountDTO.getFirstName());
        account.setEmail(accountDTO.getEmail());
        account.setImage(accountDTO.getImage());
        account.setPassword(accountDTO.getPassword());
        account.setUpdatedAt(accountDTO.getUpdatedAt());
        account.setCreatedAt(accountDTO.getCreatedAt());
        account.setAddress(accountDTO.getAddress());
        return account;
    }

    public CategoryDTO convertToCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(category.getCategoryId());
        categoryDTO.setName(category.getName());
        categoryDTO.setCreatedAt(category.getCreatedAt());
        categoryDTO.setUpdatedAt(category.getUpdatedAt());
        return categoryDTO;
    }

//    public Category convertToCategory(Category category) {
//        CategoryDTO categoryDTO = new CategoryDTO();
//        categoryDTO.setCategoryId(category.getCategoryId());
//        categoryDTO.setName(category.getName());
//        categoryDTO.setCreatedAt(category.getCreatedAt());
//        categoryDTO.setUpdatedAt(category.getUpdatedAt());
//        return categoryDTO;
//    }


    public OrderDTO convertToOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(order.getOrderId());
        orderDTO.setCreatedAt(order.getCreatedAt());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setReceiverName(order.getReceiverName());
        orderDTO.setShippingAddress(order.getShippingAddress());
        orderDTO.setToTalAmount(order.getToTalAmount());
        orderDTO.setUpdatedAt(order.getUpdatedAt());
        orderDTO.setReceiverPhoneNumber(order.getReceiverPhoneNumber());
        return orderDTO;
    }

    public OrderItemDTO convertToOrderItemDTO(OrderItem orderItem) {
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setOrderItemId(orderItem.getOrderItemId());
        orderItemDTO.setPrice(orderItem.getPrice());
        orderItemDTO.setProduct(orderItem.getProduct());
        orderItemDTO.setUpdatedAt(orderItem.getUpdatedAt());
        orderItemDTO.setCreatedAt(orderItem.getCreatedAt());
        orderItemDTO.setQuantity(orderItem.getQuantity());
        return orderItemDTO;
    }

    public PaymentMethodDTO converToPaymentMethodDTO(PaymentMethod paymentMethod) {
        PaymentMethodDTO paymentMethodDTO = new PaymentMethodDTO();
        paymentMethodDTO.setPaymentMethodId(paymentMethod.getPaymentMethodId());
        paymentMethodDTO.setActive(paymentMethod.getActive());
        paymentMethodDTO.setName(paymentMethod.getName());
        return paymentMethodDTO;
    }

    public ProductDTO convertToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setImage(product.getImage());
        productDTO.setName(product.getName());
        productDTO.setActive(product.getActive());
        productDTO.setDescription(product.getDescription());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setPrice(product.getPrice());
        productDTO.setCreatedAt(product.getCreatedAt());
        productDTO.setUpdatedAt(product.getUpdatedAt());
        return productDTO;
    }
    public UserDTO convertToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setImage(user.getImage());
        userDTO.setEmail(user.getEmail());
        userDTO.setAddress(user.getAddress());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        return userDTO;
    }

    public User converToUser(UserDTO userDTO){
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setImage(userDTO.getImage());
        user.setEmail(userDTO.getEmail());
        user.setAddress(userDTO.getAddress());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        return user;
    }
}
