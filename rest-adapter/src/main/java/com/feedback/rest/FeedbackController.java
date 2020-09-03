package com.feedback.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.domain.model.AllQuestions;
import com.feedback.domain.model.Category;
import com.feedback.domain.model.Question;
import com.feedback.domain.port.RequestFeedback;

@RestController
@RequestMapping("/api/v1/feedback")
@CrossOrigin(origins = "http://localhost:4200")
public class FeedbackController {

	@Autowired
	private RequestFeedback requestFeedback;

	@GetMapping("categories")
	public ResponseEntity<List<Category>> getCategories() {
		return ResponseEntity.ok(requestFeedback.getCategories());
	}

	@GetMapping("/questions")
	public ResponseEntity<List<AllQuestions>> getQuestions(@RequestParam("category") String category) {
		return ResponseEntity.ok(constructAllQuestions(requestFeedback.getQuestionByCategory(category)));
	}

	private List<AllQuestions> constructAllQuestions(List<Question> questions) {
		List<AllQuestions> allQuestions = new ArrayList<>();
		Map<String, List<Question>> mapOfQuestionsMap = questions.stream()
				.collect(Collectors.groupingBy(Question::getCategory));
		for (Map.Entry<String, List<Question>> entry : mapOfQuestionsMap.entrySet()) {
			allQuestions.add(AllQuestions.builder().title(entry.getKey()).questions(entry.getValue()).build());
		}
		return allQuestions;
	}

}
