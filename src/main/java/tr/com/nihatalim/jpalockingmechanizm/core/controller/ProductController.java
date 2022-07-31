package tr.com.nihatalim.jpalockingmechanizm.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.nihatalim.jpalockingmechanizm.core.entity.Product;
import tr.com.nihatalim.jpalockingmechanizm.core.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") long id) {
        return productService.getProductById(id);
    }
}
