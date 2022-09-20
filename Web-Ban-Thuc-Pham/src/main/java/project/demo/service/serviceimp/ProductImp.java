package project.demo.service.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.demo.entity.Product;
import project.demo.reponsitory.ProductReponsistory;
import project.demo.service.ProductService;

@Service
public class ProductImp implements ProductService{
	@Autowired 
	ProductReponsistory productReponsistory;

	@Override
	public List<Product> findByTitleLike(String name) {
		return productReponsistory.findByTitleLike("%"+name+"%");
	}

	@Override
	public List<Product> findByCategoryId(int id) {
		return productReponsistory.findByCategoryId(id);
	}

	@Override
	public List<Product> findAll() {
		return productReponsistory.findAll();
	}

	@Override
	public List<Product> findTopProducts() {
		return productReponsistory.findTopProducts();
	}

	@Override
	public Optional<Product> findById(Integer id) {
		return productReponsistory.findById(id);
	}

	@Override
	public Product findOneById(int id) {
		return productReponsistory.findOneById(id);
	}

	@Override
	public Product save(Product entity) {
		return productReponsistory.save(entity);
	}
	
	
	
}
