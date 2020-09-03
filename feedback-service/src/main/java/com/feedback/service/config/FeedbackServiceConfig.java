package com.feedback.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.feedback.domain.FeedbackDomain;
import com.feedback.domain.port.ObtainFeedback;
import com.feedback.domain.port.RequestFeedback;
import com.feedback.jpa.config.FeedbackJpaConfig;

@Configuration
@Import(FeedbackJpaConfig.class)
public class FeedbackServiceConfig {

	@Bean
	public RequestFeedback getRequestFeedback(final ObtainFeedback obtainFeedback) {
		return new FeedbackDomain(obtainFeedback);
	}
}
