package com.revtech.blog.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revtech.blog.domain.dtos.CategoryDto;
import com.revtech.blog.mappers.CategoryMapper;
import com.revtech.blog.services.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
	
	private final CategoryService categoryService;
	
	private final CategoryMapper categoryMapper;
	
	@GetMapping
	public ResponseEntity<List<CategoryDto>> listCatagories(){
		List<CategoryDto> categories = categoryService.listCategories()
				.stream().map(categoryMapper::toDto)
				.toList();
		return ResponseEntity.ok(categories);
	}
	
}
