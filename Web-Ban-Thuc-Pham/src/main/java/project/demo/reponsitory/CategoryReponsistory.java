package project.demo.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.demo.entity.Category;

@Repository
public interface CategoryReponsistory extends JpaRepository<Category, Integer> {

}
