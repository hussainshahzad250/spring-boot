package com.sas.cache.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sas.cache.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
