package com.mif.PSP13uzd.model;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "VARDAS")
  private String name;

  @Column(name = "PAVARDE")
  private String lastName;

  @Column(name = "TEL_NR")
  private String phoneNumber;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "ADRESAS")
  private String address;

  @Column(name = "SLAPTAZODIS")
  private String password;

  public User(String name, String lastName, String phoneNumber, String email, String address, String password) {
    this.name = name;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.address = address;
    this.password = password;
  }

  public User(Long id, String name, String lastName, String phoneNumber, String email, String address,
    String password) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.address = address;
    this.password = password;
  }

  public User() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    if(id < 0) {
      System.out.println("Klaida id=" + id + ", id negali būti mažiau negu nulis");
      throw new NullPointerException();
    }
    else this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
