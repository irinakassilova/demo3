package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Data
@Table(name="clients")
@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String first_name;

    @Column
    private  String last_name;

    @Column
    private Integer iin;
}
