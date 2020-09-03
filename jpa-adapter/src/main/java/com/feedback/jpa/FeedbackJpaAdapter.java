package com.feedback.jpa;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.feedback.domain.model.Category;
import com.feedback.domain.model.Question;
import com.feedback.domain.port.ObtainFeedback;
import com.feedback.jpa.dao.CategoryDao;
import com.feedback.jpa.dao.QuestionDao;
import com.feedback.jpa.entity.CategoryEntity;
import com.feedback.jpa.entity.QuestionEntity;
import com.feedback.jpa.mapper.FeedbackMapper;

public class FeedbackJpaAdapter implements ObtainFeedback {
	private CategoryDao categoryDao;
	private QuestionDao questionDao;

	public FeedbackJpaAdapter(CategoryDao categoryDao, QuestionDao questionDao) {
		this.categoryDao = categoryDao;
		this.questionDao = questionDao;
	}

	@Override
	public List<Category> getCategories() {
		Iterable<CategoryEntity> categoryEntities = this.categoryDao.findAll();
		return FeedbackMapper.FEEDBACK_MAPPER.constructCategories(
				StreamSupport.stream(categoryEntities.spliterator(), false).collect(Collectors.toList()));
	}

	@Override
	public List<Question> getQuestionByCategory(String category) {
		List<QuestionEntity> questionEntities = this.questionDao.findDistinctByCategory(category);
		return FeedbackMapper.FEEDBACK_MAPPER.constructQuestions(questionEntities);
	}
}
