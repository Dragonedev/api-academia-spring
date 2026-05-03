package br.com.edu.spring_boot_essentials.database.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductEntity {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
