package com.revtech.blog.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revtech.blog.domain.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
