package com.feedback.domain.model;

import java.util.List;

import com.google.gson.JsonObject;

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
public class Category {

	private String title;
	private String description;
	private List<String> tags;
	private String image;
}
