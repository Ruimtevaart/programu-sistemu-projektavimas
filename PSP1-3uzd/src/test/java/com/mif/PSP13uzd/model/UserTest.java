package com.mif.PSP13uzd.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserTest {

  @Test
  void testUserConstructor() {
    User user = new User("Grantas", "Bičiulaitis", "37073518676", "email@gmail.com", "Kauno g. 14", "Labas123!");
    assertAll("User konstruktoriaus testas",
      () -> assertNull(user.getId()),
      () -> assertEquals("Grantas", user.getName()),
      () -> assertEquals("Bičiulaitis", user.getLastName()),
      () -> assertEquals("37073518676", user.getPhoneNumber()),
      () -> assertEquals("email@gmail.com", user.getEmail()),
      () -> assertEquals("Kauno g. 14", user.getAddress()),
      () -> assertEquals("Labas123!", user.getPassword()));
  }

  @Test
  void testSetId() {
    User user = new User();
    assertThrows(NullPointerException.class, () -> user.setId((long) -1));
  }
}
