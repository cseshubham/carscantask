package com.svs.usermanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.svs.usermanage.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
