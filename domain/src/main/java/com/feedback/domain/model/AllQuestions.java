package com.feedback.domain.model;

import java.util.List;

import com.feedback.domain.model.Category.CategoryBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AllQuestions {

	private String title;
	private List<Question> questions;
}
