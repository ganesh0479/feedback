package com.feedback.domain.port;

import java.util.List;

import com.feedback.domain.model.Category;
import com.feedback.domain.model.Question;

public interface RequestFeedback {
	List<Category> getCategories();
	List<Question> getQuestionByCategory(String category);

}
