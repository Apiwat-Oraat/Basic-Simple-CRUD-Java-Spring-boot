package com.example.temp.dtos;

public class UserDto {
  private String name;
  private String email;
  private String id;


  public UserDto(String id, String name, String email){
    this.name = name;
    this.email = email;
    this.id = id;
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
