package com.example.project.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {
    @Column(name = "create_at")
    private LocalDate createdAt;
    @Column(name = "update_at")
    private LocalDate updatedAt;
}
