package com.example.demo.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name="actions")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Temporal(TemporalType.DATE)
    @Column
    private Date begin_date;

    @Temporal(TemporalType.DATE)
    @Column
    private Date end_date;

    @OneToOne
    @Fetch(FetchMode.SELECT)
    private Product product;

}
