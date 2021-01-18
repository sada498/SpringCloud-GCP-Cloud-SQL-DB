package com.sada.SpringCloudGCPCloud.SQLDB;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @PostMapping
    public Product create(@RequestBody Product productDetails){
        return productRepository.save(productDetails);
    }
    @GetMapping("{id}")
    public Product read(@PathVariable String id ){
        return new Product();
    }
    @PutMapping("{id}")
    public Product update(@RequestBody Product productDetails, @PathVariable String id){
        return new Product();
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){

    }
}
