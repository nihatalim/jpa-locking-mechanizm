package tr.com.nihatalim.jpalockingmechanizm.core.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tr.com.nihatalim.jpalockingmechanizm.core.entity.Product;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select p from Product p WHERE p.id = :id")
    @QueryHints(
            @QueryHint(name = "javax.persistence.lock.timeout", value = "1000")
    )
    Optional<Product> getProductById(@Param("id") Long id);

    @Lock(LockModeType.PESSIMISTIC_READ)
    @Query("select p from Product p order by p.id asc")
    List<Product> getAllProducts(Pageable pageable);
}
