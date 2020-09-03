package com.feedback.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.feedback.domain.port.ObtainFeedback;
import com.feedback.jpa.FeedbackJpaAdapter;
import com.feedback.jpa.dao.CategoryDao;
import com.feedback.jpa.dao.QuestionDao;

@Configuration
public class FeedbackJpaConfig {

	@Bean
	public ObtainFeedback getFeedbackJpaAdapter(final CategoryDao categoryDao, final QuestionDao questionDao) {
		return new FeedbackJpaAdapter(categoryDao, questionDao);
	}
}
