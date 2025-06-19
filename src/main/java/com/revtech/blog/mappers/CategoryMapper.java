package com.revtech.blog.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import com.revtech.blog.domain.PostStatus;
import com.revtech.blog.domain.dtos.CategoryDto;
import com.revtech.blog.domain.entities.Category;
import com.revtech.blog.domain.entities.Post;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {
	
	@Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
	CategoryDto toDto(Category category);
	
	@Named("calculatePostCount")
	default long calculatePostCount(List<Post> posts) {
		if(null == posts) {
			return 0;
		}
		return posts.stream()
				.filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
				.count();
	}
}
