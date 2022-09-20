package project.demo.service.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.demo.entity.User;
import project.demo.reponsitory.UserReponsistory;
import project.demo.service.UserService;

@Service
public class UserImp implements UserService {
	
	@Autowired
	UserReponsistory userReponsistory;

	@Override
	public Iterable<User> findAll() {
		return (List<User>)userReponsistory.findAll();
	}

	@Override
	public <S extends User> S save(S entity) {
		return userReponsistory.save(entity);
	}

	
}
