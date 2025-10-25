package com.example.temp.repositories;

import java.lang.foreign.Linker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.temp.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
  // @Query("SELECT u FROM UserModel u WHERE u.email = :email")
  // Optional<UserModel> findByEmail(@Param("email") String email);

  Optional<UserModel> findByEmail(String email);
}
