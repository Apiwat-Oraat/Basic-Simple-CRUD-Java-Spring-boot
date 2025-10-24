package com.example.temp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.temp.repositories.UserRepository;
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
    return userRepository.getUsers().stream()
        .map(user -> new UserDto(user.getid(), user.getName(), user.getEmail()))
        .toList();
  }

  @GetMapping("/users/{id}")
  public UserDto getUserbyId(@PathVariable String id) {
    return userRepository.getUsers().stream()
        .filter(user -> user.getid().equals(id))
        .map(user -> new UserDto(user.getid(), user.getName(), user.getEmail()))
        .findFirst()
        .orElse(null);
  }

  @PostMapping("/users")
  public String createUser(@RequestBody UserDto userDto) {
    userRepository
        .addUser(new UserModel(userDto.getName(), userDto.getEmail()));
    return "User create successfully";
  }

  @PutMapping("users/{id}")
  public String updateUser(@PathVariable String id, @RequestBody UserDto userDto) {
    UserModel updatedUser = new UserModel(id, userDto.getName(), userDto.getEmail());
    userRepository.editUser(updatedUser);
    return "User updated successfully";
  }

  @DeleteMapping("/user/{id}")
  public String deleteUser(@PathVariable String id) {
    UserModel userToDelete = userRepository.getUsers().stream()
        .filter(user -> user.getid().equals(id))
        .findFirst()
        .orElse(null);
    if (userToDelete != null) {
      userRepository.removeUser(userToDelete);
      return "User deleted successfully";
    }

    return "User not found";
  }

}
