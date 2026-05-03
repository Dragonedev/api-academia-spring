package br.com.edu.spring_boot_essentials.service;

import br.com.edu.spring_boot_essentials.database.model.ProductEntity;
import br.com.edu.spring_boot_essentials.dto.ProductDto;
import br.com.edu.spring_boot_essentials.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private static final List<ProductEntity> PRODUTOS = new ArrayList<>();
    static {
        PRODUTOS.add(ProductEntity.builder()
                    .id(1)
                    .name("Pelúcia Jacaré")
                    .price(new BigDecimal (200))
                    .quantity(1)
                    .build());
            PRODUTOS.add(ProductEntity.builder()
                    .id(2)
                    .name("G Pro SuperLight Red")
                    .price(new BigDecimal(700))
                    .quantity(1)
                    .build());
            PRODUTOS.add(ProductEntity.builder()
                    .id(3)
                    .name("Iphone 15")
                    .price(new BigDecimal(4000))
                    .quantity(1)
                    .build());
    }
    public List<ProductEntity> findAll(){
        return new ArrayList<>(PRODUTOS);
    }

    public ProductEntity createProduct (ProductDto productDto){

        Integer id = PRODUTOS.stream()
                .mapToInt(ProductEntity::getId)
                .max()
                .orElse(0) +1 ;

                ProductEntity newProduct = ProductEntity.builder()
                .id(id)
                .name(productDto.getName())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .build();

        PRODUTOS.add(newProduct);
        return newProduct;
    }

    public ProductEntity uptadeProduct(ProductDto productDto, Integer id) throws NotFoundException {

        ProductEntity product = PRODUTOS.stream()
                .filter(p -> p.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new NotFoundException ("Produto não Encontrado"));

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());

        return product;
    }

    public void deleteProduct(Integer id) throws NotFoundException {
        ProductEntity product = PRODUTOS.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Produto não Encontrado"));

        PRODUTOS.remove(product);
    }
}
