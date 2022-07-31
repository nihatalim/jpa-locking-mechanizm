package tr.com.nihatalim.jpalockingmechanizm.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.nihatalim.jpalockingmechanizm.core.entity.ProductItem;

@Repository
public interface IProductItemRepository extends JpaRepository<ProductItem, Long> {
}
