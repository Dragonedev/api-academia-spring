package br.com.edu.spring_boot_essentials.controller;

import br.com.edu.spring_boot_essentials.database.model.ProductEntity;
import br.com.edu.spring_boot_essentials.dto.ProductDto;
import br.com.edu.spring_boot_essentials.exception.NotFoundException;
import br.com.edu.spring_boot_essentials.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductEntity> findAll(){

        return productService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity createProduct (@RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity uptadeProduct (@PathVariable Integer id,
                                        @RequestBody ProductDto productDto) throws NotFoundException {
        return productService.uptadeProduct(productDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Integer id) throws NotFoundException {
        productService.deleteProduct(id);
    }




}
