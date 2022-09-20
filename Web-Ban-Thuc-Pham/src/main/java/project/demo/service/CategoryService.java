package project.demo.service;

import java.util.List;
import java.util.Optional;

import project.demo.entity.Category;

public interface CategoryService {
	public List<Category> findAll() ;

	Category save(Category entity);

	Optional<Category> findById(Integer id);
}
