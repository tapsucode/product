package project.demo.service.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.demo.entity.Feedback;
import project.demo.reponsitory.FeedbackReponsistory;
import project.demo.service.FeedbackService;
@Service
public class FeedbackImp implements FeedbackService{
	@Autowired
	FeedbackReponsistory feedbackReponsistory;

	@Override
	public Feedback save(Feedback entity) {
		return feedbackReponsistory.save(entity);
	}
}
