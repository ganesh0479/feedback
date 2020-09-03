package com.feedback.domain;

import java.util.List;

import com.feedback.domain.model.Category;
import com.feedback.domain.model.Question;
import com.feedback.domain.port.ObtainFeedback;
import com.feedback.domain.port.RequestFeedback;

public class FeedbackDomain implements RequestFeedback{

	private ObtainFeedback obtainFeedback;

	public FeedbackDomain(final ObtainFeedback obtainFeedback) {
		this.obtainFeedback = obtainFeedback;
	}
	
	public List<Category> getCategories(){
		return obtainFeedback.getCategories();
	}

	@Override
	public List<Question> getQuestionByCategory(String category) {
		// TODO Auto-generated method stub
		return obtainFeedback.getQuestionByCategory(category);
	}
}
