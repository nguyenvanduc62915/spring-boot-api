package com.example.project.Init;

import com.example.project.Entity.Account;
import com.example.project.Entity.User;
import com.example.project.Repository.AccountRepository;
import com.example.project.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitCommandLine {
    private static boolean initData = true;

    @Bean
    CommandLineRunner initCommandLineRunnerAccount(AccountRepository accountRepository) {
        return args -> {
            accountRepository.saveAll(List.of(
                    new Account(null, "Nguyễn", "Văn Đức", "duc@gmail.com", "0169314654", "123.png", "Hải Dương", null),
                    new Account(null, "Nguyễn", "Thành Đạt", "dat@gmail.com", "0885868231", "456.png", "Hải Dương", null),
                    new Account(null, "Phạm", "Ngọc Khánh", "khanh@gmail.com", "0944591181", "789.png", "Hải Dương", null)
                    // Thêm các bản ghi Account khác tại đây nếu cần
            ));
        };
    }

    @Bean
    CommandLineRunner initCommandLineRunnerUser(UserRepository userRepository) {
        return args -> {
            userRepository.saveAll(List.of(
                    new User(null, "Nguyễn", "Văn Đức", "duc@gmail.com", "123.png", "Hải Dương", "0169314654", null, null),
                    new User(null, "Nguyễn", "Thành Đạt", "dat@gmail.com", "456.png", "Hải Dương", "0885868231", null, null),
                    new User(null, "Phạm", "Ngọc Khánh", "khanh@gmail.com", "789.png", "Hải Dương", "0944591181", null, null)
                    // Thêm các bản ghi Account khác tại đây nếu cần
            ));
        };
    }
}
