package project.demo.service.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.demo.entity.Category;
import project.demo.reponsitory.CategoryReponsistory;
import project.demo.service.CategoryService;

@Service
public class CategoryImp implements CategoryService {
	
	@Autowired
	CategoryReponsistory category;

	public List<Category> findAll() {
		return category.findAll();
	}

	@Override
	public Category save(Category entity) {
		return category.save(entity);
	}

	@Override
	public Optional<Category> findById(Integer id) {
		return category.findById(id);
	}
	
	
}
