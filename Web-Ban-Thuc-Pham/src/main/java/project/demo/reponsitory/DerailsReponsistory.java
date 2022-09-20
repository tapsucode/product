package project.demo.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.demo.entity.Order_details;

@Repository
public interface DerailsReponsistory extends JpaRepository<Order_details, Integer> {

}
