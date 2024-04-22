package com.example.project.Init;

import com.example.project.Entity.Account;
import com.example.project.Entity.Category;
import com.example.project.Entity.Product;
import com.example.project.Entity.User;
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

    @Bean
    public CommandLineRunner seedData() {
        return args -> {
            seedAccount();
            seedUser();
            seedCategory();
            seedProduct();
        };
    }

    private void seedAccount() {
        if (accountRepository.count() == 0) {
            accountRepository.saveAll(List.of(
                    new Account(null, "Nguyễn", "Văn Đức", "duc@gmail.com", "0169314654", "123.png", "Hải Dương", null),
                    new Account(null, "Nguyễn", "Thành Đạt", "dat@gmail.com", "0885868231", "456.png", "Hải Dương", null),
                    new Account(null, "Phạm", "Ngọc Khánh", "khanh@gmail.com", "0944591181", "789.png", "Hải Dương", null)
            ));
        }
    }

    private void seedUser() {
        if (userRepository.count() == 0) {
            userRepository.saveAll(List.of(
                    new User(null, "Nguyễn", "Văn Đức", "duc@gmail.com", "123.png", "Hải Dương", "0169314654", null, null),
                    new User(null, "Nguyễn", "Thành Đạt", "dat@gmail.com", "456.png", "Hải Dương", "0885868231", null, null),
                    new User(null, "Phạm", "Ngọc Khánh", "khanh@gmail.com", "789.png", "Hải Dương", "0944591181", null, null)
            ));
        };
    }

    private void seedCategory() {
        if (categoryRepository.count() == 0) {
            categoryRepository.saveAll(List.of(
                    new Category(1L, "Đồ ăn vặt",null),
                    new Category(2L, "Trà sữa", null),
                    new Category(3L, "Cafe", null)
            ));
        };
    }

    private void seedProduct() {
        if (productRepository.count() == 0) {
            productRepository.saveAll(List.of(
                    new Product(1L, "Bim Bim Ngô", "bimbim@gmail.com", 5000.0, 1, "Ngon, bổ, rẻ", true, null, null),
                    new Product(2L, "Trà sữa trân châu đường đen 90%", "trasua@gmail.com", 35000.0, 2, "Ngon, bổ, rẻ", true, null, null),
                    new Product(3L, "Cafe", "cafe@gmail.com", 70000.0, 3, "Ngon, bổ, rẻ", false, null, null)
            ));
        };
    }
}
