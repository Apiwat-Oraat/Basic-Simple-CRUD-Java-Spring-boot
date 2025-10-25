package com.example.temp.models;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserModel {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
  

  public UserModel(){

  }
  public UserModel(String name, String email){
    this.name = name;
    this.email = email;
  }

  public Long getid(){
    return id;
  }

  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
  }

  public String getEmail(){
    return email;
  }
  public void setEmail(String email){
    this.email = email;
  }
}
