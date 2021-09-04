package session.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import session.model.Product;
import session.repository.IproductRepo;

import java.util.Optional;

@Service
public class ProductService implements IproductService {
    @Autowired
    IproductRepo iproductRepo;

    @Override
    public Iterable<Product> findAll() {
        return iproductRepo.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iproductRepo.findById(id);
    }

    @Override
    public void save(Product product) {
        iproductRepo.save(product);
    }

    @Override
    public void delete(Product product) {
        iproductRepo.delete(product);
    }
}
