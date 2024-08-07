package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Role;
import com.entity.User;

@Repository
public interface UserRoleRepository extends JpaRepository<Role, Long> {
}
