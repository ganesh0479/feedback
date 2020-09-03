package com.feedback.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.feedback.jpa.entity.CategoryEntity;

@Repository
public interface CategoryDao extends CrudRepository<CategoryEntity, String> {

}
