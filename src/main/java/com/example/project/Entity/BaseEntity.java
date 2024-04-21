package com.example.project.Entity;

import jakarta.persistence.*;
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
    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDate.now();
    }
    @PreUpdate
    public void preUpdate(){
        this.updatedAt = LocalDate.now();
    }
}
