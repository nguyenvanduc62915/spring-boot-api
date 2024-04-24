package com.example.project.Init;

import com.example.project.Entity.*;
import com.example.project.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitCommandLine {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Bean
    public CommandLineRunner seedData() {
        return args -> {
            seedAccount();
            seedUser();
            seedCategory();
            seedProduct();
            seedOrder();
            seedOrderItem();
            seedPaymentMethod();
        };
    }

    private void seedAccount() {
        if (accountRepository.count() == 0) {
            accountRepository.saveAll(List.of(
                    new Account(1L, "Nguyễn", "Văn Đức", "duc@gmail.com", "0169314654", "123.png", "Hải Dương", null),
                    new Account(2L, "Nguyễn", "Thành Đạt", "dat@gmail.com", "0885868231", "456.png", "Hải Dương", null),
                    new Account(3L, "Phạm", "Ngọc Khánh", "khanh@gmail.com", "0944591181", "789.png", "Hải Dương", null)
            ));
        }
    }

    private void seedUser() {
        if (userRepository.count() == 0) {
            Account account_1 = new Account(1L, "Nguyễn", "Văn Đức", "duc@gmail.com", "0169314654", "123.png", "Hải Dương", null);
            Account account_2 = new Account(2L, "Nguyễn", "Thành Đạt", "dat@gmail.com", "0885868231", "456.png", "Hải Dương", null);
            Account account_3 = new Account(3L, "Phạm", "Ngọc Khánh", "khanh@gmail.com", "0944591181", "789.png", "Hải Dương", null);
            userRepository.saveAll(List.of(
                    new User(1L, "Nguyễn", "Văn Đức", "duc@gmail.com", "123.png", "Hải Dương", "0169314654", null, account_1),
                    new User(2L, "Nguyễn", "Thành Đạt", "dat@gmail.com", "456.png", "Hải Dương", "0885868231", null, account_2),
                    new User(3L, "Phạm", "Ngọc Khánh", "khanh@gmail.com", "789.png", "Hải Dương", "0944591181", null, account_3)
            ));
        }
        ;
    }

    private void seedCategory() {
        if (categoryRepository.count() == 0) {
            categoryRepository.saveAll(List.of(
                    new Category(1L, "Đồ ăn vặt", null),
                    new Category(2L, "Trà sữa", null),
                    new Category(3L, "Cafe", null)
            ));
        }
        ;
    }

    private void seedProduct() {
        if (productRepository.count() == 0) {
            Category category_1 = new Category(1L, "Đồ ăn vặt", null);
            Category category_2 = new Category(2L, "Trà sữa", null);
            Category category_3 = new Category(3L, "Cafe", null);
            productRepository.saveAll(List.of(
                    new Product(1L, "Bim Bim Ngô", "bimbim@gmail.com", 5000.0, 1, "Ngon, bổ, rẻ", true, category_2, null),
                    new Product(2L, "Trà sữa trân châu đường đen 90%", "trasua@gmail.com", 35000.0, 2, "Ngon, bổ, rẻ", true, category_1, null),
                    new Product(3L, "Cafe", "cafe@gmail.com", 50000.0, 3, "Ngon, bổ, rẻ", false, category_3, null)
            ));
        }
        ;
    }

    private void seedOrder() {
        if (orderRepository.count() == 0) {
            orderRepository.saveAll(List.of(
                    new Order(1L, "Hóa đơn bán hàng", "0944591182", 4000000.0, "Đã nhận hàng", "Số 8, ngõ 515 An Dương Vương, Đông Ngạc, Bắc Từ Liêm, Hà Nội", null, null, null),
                    new Order(2L, "Hóa đơn bán hàng", "0944591183", 12000000.0, "Chờ vận chuyển", "Tạp hóa Thẫm Tuấn, Cẩm Đoài, Cẩm Giàng, Hải Dương", null, null, null),
                    new Order(3L, "Hóa đơn bán hàng", "0944591184", 78000000.0, "Đã thanh toán", "Số 16 Lê Thành Nghị, Phường Bách Khoa, Quận Hai Bà Trưng, Hà Nội", null, null, null)
            ));
        }
        ;
    }

    private void seedOrderItem() {
        if (orderItemRepository.count() == 0) {
            orderItemRepository.saveAll(List.of(
                    new OrderItem(1L, 2, 35000.0, null, null),
                    new OrderItem(2L, 10, 5000.0, null, null),
                    new OrderItem(3L, 7, 50000.0, null, null)
            ));
        }
        ;
    }

    private void seedPaymentMethod() {
        if (paymentMethodRepository.count() == 0) {
            paymentMethodRepository.saveAll(List.of(
                    new PaymentMethod(1, "Thanh toán khi nhân hàng", true, null),
                    new PaymentMethod(2, "Thẻ tín dụng/thẻ ghi nợ", true, null),
                    new PaymentMethod(3, "Thẻ ATM nội địa", true, null)
            ));
        }
        ;
    }
}
