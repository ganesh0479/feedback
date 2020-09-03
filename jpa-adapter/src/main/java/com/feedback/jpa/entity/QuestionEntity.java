package com.feedback.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table(name = "Question")
public class QuestionEntity {
	@Id
	@Column(name = "category")
	private String category;
	
	@Column(name = "question")
	private String question;
	
	@Column(name = "answers")
	private String answers;
	
	@Column(name = "likes")
	private Integer like;
	
	@Column(name = "dislike")
	private Integer dislike;
}
