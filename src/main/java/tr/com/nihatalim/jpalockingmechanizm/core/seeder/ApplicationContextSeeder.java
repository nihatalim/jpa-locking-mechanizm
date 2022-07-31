package tr.com.nihatalim.jpalockingmechanizm.core.seeder;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tr.com.nihatalim.jpalockingmechanizm.core.entity.Product;
import tr.com.nihatalim.jpalockingmechanizm.core.entity.ProductItem;
import tr.com.nihatalim.jpalockingmechanizm.core.enums.ProductProcessEnum;
import tr.com.nihatalim.jpalockingmechanizm.core.repository.IProductItemRepository;
import tr.com.nihatalim.jpalockingmechanizm.core.repository.IProductRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class ApplicationContextSeeder {
    private final IProductRepository productRepository;
    private final IProductItemRepository productItemRepository;

    public ApplicationContextSeeder(IProductRepository productRepository, IProductItemRepository productItemRepository) {
        this.productRepository = productRepository;
        this.productItemRepository = productItemRepository;
    }

    @PostConstruct
    public void initialize() {
        if (productRepository.count() < 1) {
            this.initializeProducts();
            this.initializeProductItems();
        }
    }

    @Transactional
    private void initializeProducts() {
        List<Product> products = IntStream.range(0, 10)
                .mapToObj(i -> {
                    Product product = new Product();
                    product.setProductName("Product_" + i);
                    return product;
                }).collect(Collectors.toList());

        productRepository.saveAll(products);
    }

    @Transactional
    private void initializeProductItems() {
        productRepository.getAllProducts(Pageable.ofSize(10))
                .forEach(product -> {
                    List<ProductItem> productItems = IntStream.range(0, 4)
                            .mapToObj(i -> {
                                ProductItem productItem = new ProductItem();
                                productItem.setProductId(product.getId());
                                productItem.setProcessDate(null);
                                productItem.setProcessStatus(ProductProcessEnum.NOT_STARTED.getStatus());
                                return productItem;
                            }).collect(Collectors.toList());

                    productItemRepository.saveAll(productItems);
                });
    }
}
