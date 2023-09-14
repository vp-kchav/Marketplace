package com.intuit.hiring.craft.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intuit.hiring.craft.marketplace.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
