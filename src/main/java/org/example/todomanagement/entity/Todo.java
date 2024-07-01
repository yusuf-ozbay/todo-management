package org.example.todomanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todos")     //bu tabloyu bu entityle bir veritabanında eşleştirir
public class Todo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private  String descripton;

    @Column(nullable = false)
    private  boolean comleted;

}
