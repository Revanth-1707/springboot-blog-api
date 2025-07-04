package com.revtech.blog.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revtech.blog.domain.entities.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, UUID>{

}
