package project.demo.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import project.demo.entity.Product;

@Repository
public interface ProductReponsistory extends JpaRepository<Product, Integer> {
	
	List<Product> findByTitleLike(String name);
	
	List<Product> findByCategoryId(int id);
	
	@Query(value = "SELECT * FROM product ORDER BY (price/discount) DESC LIMIT 4", nativeQuery = true )
	List<Product> findTopProducts();
	
	@Query(value = "select*from product where id=?1",nativeQuery = true)
	Product findOneById(int id);
}
