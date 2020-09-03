package com.feedback.domain.model;

import java.util.List;

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
public class Question {
	private String category;

	private String question;

	private List<String> answers;

	private Integer like;

	private Integer dislike;
}
