package session.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import session.model.Product;
@Repository
public interface IproductRepo extends PagingAndSortingRepository<Product,Long> {
}
