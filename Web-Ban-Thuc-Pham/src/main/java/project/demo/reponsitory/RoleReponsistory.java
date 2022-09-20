package project.demo.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import project.demo.entity.Product;
import project.demo.entity.Role;

@Repository
public interface RoleReponsistory extends JpaRepository<Role, Integer> {
	
	@Query(value = "select*from role where id=?1",nativeQuery = true)
	Role findOneById(int id);
}
