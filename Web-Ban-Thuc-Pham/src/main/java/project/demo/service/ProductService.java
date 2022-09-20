package project.demo.service;

import java.util.List;
import java.util.Optional;

import project.demo.entity.Product;

public interface ProductService {

	List<Product> findByTitleLike(String name);

	List<Product> findByCategoryId(int id);

	List<Product> findAll();

	List<Product> findTopProducts();

	Optional<Product> findById(Integer id);

	Product findOneById(int id);

	Product save(Product entity);

}
