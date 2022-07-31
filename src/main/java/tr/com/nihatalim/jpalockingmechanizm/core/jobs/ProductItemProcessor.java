package tr.com.nihatalim.jpalockingmechanizm.core.jobs;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.nihatalim.jpalockingmechanizm.core.entity.Product;
import tr.com.nihatalim.jpalockingmechanizm.core.repository.IProductRepository;


@Service
public class ProductItemProcessor {
    private final IProductRepository productRepository;

    public ProductItemProcessor(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    @Scheduled(fixedRate = 30000, initialDelay = 3000)
    public void process() throws InterruptedException {
        // TODO : product item processor is a job that process ProductItems
        System.out.println("[ProductItemProcessor] [process] Thread: " + Thread.currentThread().getName());

        Product product  = productRepository.getProductById(21L)
                .orElse(null);

        Thread.sleep(20000);
    }
}
