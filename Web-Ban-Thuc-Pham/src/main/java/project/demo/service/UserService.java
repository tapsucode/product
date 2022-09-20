package project.demo.service;


import project.demo.entity.User;

public interface UserService {

	Iterable<User> findAll();

	<S extends User> S save(S entity);
	

}
