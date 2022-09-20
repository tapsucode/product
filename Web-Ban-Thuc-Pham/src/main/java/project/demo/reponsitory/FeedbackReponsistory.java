package project.demo.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.demo.entity.Feedback;

@Repository
public interface FeedbackReponsistory extends JpaRepository<Feedback, Integer> {

}
