package project.demo.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.demo.entity.Order;

@Repository
public interface OrderReponsistory extends JpaRepository<Order,Integer> {

}
