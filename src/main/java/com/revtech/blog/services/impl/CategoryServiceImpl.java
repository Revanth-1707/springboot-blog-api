package com.revtech.blog.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revtech.blog.domain.entities.Category;
import com.revtech.blog.repository.CategoryRepository;
import com.revtech.blog.services.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

	private final CategoryRepository categoryRepository;
	
	@Override
	public List<Category> listCategories() {
		return categoryRepository.findAllWithPostCount();
	}

}
