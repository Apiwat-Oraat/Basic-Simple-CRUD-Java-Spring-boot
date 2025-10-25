package com.example.temp.dtos;

import jakarta.validation.constraints.NotBlank;

public class UserDto {
  private String name;

  @NotBlank(message = "Email is required")
  private String email;

  private String id;


  public UserDto(String name, String email){
    this.name = name;
    this.email = email;
  }

  public String getid(){
    return id;
  }

  public String getName(){
    return name;
  }

  public String getEmail(){
    return email;
  }


}
