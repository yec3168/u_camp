package com.ucamp.myspringboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter @Setter
@Table(name = "customers") // 테이블의 이름을 정함.
@DynamicUpdate
public class Customer {
    @Id
    /**
     *  Identify : Mysql, MariaDB
     *  Sequence : oracle, postgreSQL
     *  Auto : 자동으로 알맞는 타입을 지정해줌.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY) // h2
    private Long id;

    @Column(unique = true, nullable = false) // 중복 x, null값 x
    private String customerId;

    @Column(nullable = false)
    private String customerName;
}
