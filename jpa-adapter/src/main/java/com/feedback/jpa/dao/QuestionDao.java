package com.feedback.jpa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.feedback.jpa.entity.QuestionEntity;

@Repository
public interface QuestionDao extends CrudRepository<QuestionEntity, String> {

	List<QuestionEntity> findDistinctByCategory(String category);
}
