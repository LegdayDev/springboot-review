package com.apple.shop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
@NoArgsConstructor
@Entity
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // String 은 255자만 넣을수 있지만 긴 문자열을 넣을 수 있따.
//    @Column(nullable = false, columnDefinition = "TEXT")
    @Column(nullable = false, length = 1000)
    private String title;

    @Column(nullable = false)
    private Integer price;
}
