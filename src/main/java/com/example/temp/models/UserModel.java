package com.example.temp.models;

public class UserModel {
  
  private String name;
  private String email;
  private String id;

  public UserModel(){

  }
  public UserModel(String name, String email){
    this.id = String.valueOf(System.currentTimeMillis());
    this.name = name;
    this.email = email;
  }
  public UserModel(String id, String name, String email){
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
