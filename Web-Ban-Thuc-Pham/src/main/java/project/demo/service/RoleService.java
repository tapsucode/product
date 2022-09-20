package project.demo.service;

import project.demo.entity.Role;

public interface RoleService {

	Role findOneById(int id);

	Role save(Role entity);

}
