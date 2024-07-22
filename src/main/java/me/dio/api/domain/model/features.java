package me.dio.api.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_features")
public class features {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}