package br.com.edu.spring_boot_essentials.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductDto {
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
