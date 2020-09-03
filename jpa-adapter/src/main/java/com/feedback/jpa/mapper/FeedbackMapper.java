package com.feedback.jpa.mapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import com.feedback.domain.model.Category;
import com.feedback.domain.model.Question;
import com.feedback.jpa.entity.CategoryEntity;
import com.feedback.jpa.entity.QuestionEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public enum FeedbackMapper {

	FEEDBACK_MAPPER;

	public List<Category> constructCategories(final List<CategoryEntity> categoryEntities) {
		return CollectionUtils.isEmpty(categoryEntities) ? Collections.emptyList()
				: categoryEntities.stream().map(this::constructCategory).collect(Collectors.toList());
	}

	public Category constructCategory(final CategoryEntity categoryEntity) {
		Category category = new Category();
		category.setTitle(categoryEntity.getCategory());
		category.setDescription(categoryEntity.getDescription());
		category.setTags(convertStringToList(categoryEntity.getTags()));
		category.setImage(categoryEntity.getImage());
		return category;
	}

	private List<String> convertStringToList(final String str) {
		return Arrays.asList(str.split(",")).stream().map(action -> {
			action = action.replace("{", "");
			action = action.replace("}", "");
			action = action.replace("\"", "");
			return action;
		}).collect(Collectors.toList());
	}

	public List<Question> constructQuestions(final List<QuestionEntity> questionEntity) {
		return CollectionUtils.isEmpty(questionEntity) ? Collections.emptyList()
				: questionEntity.stream().map(this::constructQuestion).collect(Collectors.toList());
	}

	public Question constructQuestion(final QuestionEntity questionEntity) {
		return Question.builder().answers(convertStringToList(questionEntity.getAnswers()))
				.dislike(questionEntity.getDislike()).question(questionEntity.getQuestion())
				.category(questionEntity.getCategory()).like(questionEntity.getLike()).build();
	}

}
