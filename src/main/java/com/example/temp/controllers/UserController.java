package com.example.temp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.temp.repositories.UserRepository;

import jakarta.validation.Valid;

import com.example.temp.dtos.UserDto;
import com.example.temp.models.UserModel;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class UserController {

  private UserRepository userRepository;

  private UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/users")
  public List<UserDto> getUsers() {
    return userRepository.findAll().stream()
        .map(user -> new UserDto(user.getName(), user.getEmail()))
        .toList();
  }

  @GetMapping("/users/{id}")
  public UserDto getUserbyId(@PathVariable String id) {
    return userRepository.findAll().stream()
        .filter(user -> user.getid().equals(id))
        .map(user -> new UserDto(user.getName(), user.getEmail()))
        .findFirst()
        .orElse(null);
  }

  @PostMapping("/users")
  public String createUser(@RequestBody UserDto userDto) {
    userRepository
        .save(new UserModel(userDto.getName(), userDto.getEmail()));
    return "User create successfully";
  }

  @PutMapping("users/{id}")
  public String updateUser(@PathVariable String id, @RequestBody UserDto userDto) {
    UserModel updatedUser = new UserModel(userDto.getName(), userDto.getEmail());
    userRepository.save(updatedUser);
    return "User updated successfully";
  }

  @DeleteMapping("/users/{id}")
  public String deleteUser(@PathVariable String id) {
    UserModel userToDelete = userRepository.findAll().stream()
        .filter(user -> user.getid().equals(id))
        .findFirst()
        .orElse(null);
    if (userToDelete != null) {
      userRepository.delete(userToDelete);
      return "User deleted successfully";
    }

    return "User not found";
  }

  @PostMapping("/users/search")
  public UserDto getUserByEmail(@Valid @RequestBody UserDto userDto) {
      return userRepository.findByEmail(userDto.getEmail())
      .map(user -> new UserDto(user.getName(), user.getEmail()))
      .orElse(null);
  }
  

}
