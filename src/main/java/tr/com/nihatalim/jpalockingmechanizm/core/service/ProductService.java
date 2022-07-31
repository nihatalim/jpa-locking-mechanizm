package tr.com.nihatalim.jpalockingmechanizm.core.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.nihatalim.jpalockingmechanizm.core.entity.Product;
import tr.com.nihatalim.jpalockingmechanizm.core.repository.IProductRepository;

@Service
@Transactional
public class ProductService {
    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product getProductById(Long id) {
        return productRepository.getProductById(id).orElse(null);
    }
}
