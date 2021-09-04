package session.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import session.model.Product;

import java.util.Optional;

public interface IproductService {

    Iterable<Product> findAll();

    Optional<Product> findById(Long id);

    void save(Product product);

    void delete(Product product);
}
