package com.ORsystem.Model;  // Updated package

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "departments")
@Data
@AllArgsConstructor
public class Depclass {  // Model name remains Depclass

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private String abbreviatedName;

    public Depclass() {
    }
}