package project.demo.service.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.demo.entity.Role;
import project.demo.reponsitory.RoleReponsistory;
import project.demo.service.RoleService;

@Service
public class RoleImp implements RoleService {
	
	@Autowired
	RoleReponsistory roleReponsistory;

	
	@Override
	public Role findOneById(int id) {
		return roleReponsistory.findOneById(id);
	}


	@Override
	public Role save(Role entity) {
		return roleReponsistory.save(entity);
	}
	
	
}
