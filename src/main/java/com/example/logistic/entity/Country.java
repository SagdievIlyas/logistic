package com.example.logistic.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter

@Entity
@Table(name = "country")
public class Country {
    @Id
    private Long id;

    private String name;
}
