package project.demo.reponsitory;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.demo.entity.User;

@Repository
public interface UserReponsistory extends JpaRepository<User, Integer> {

}
