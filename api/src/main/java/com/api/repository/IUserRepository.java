package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

}
