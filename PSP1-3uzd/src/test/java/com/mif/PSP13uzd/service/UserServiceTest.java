package com.mif.PSP13uzd.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.mif.PSP13uzd.model.User;
import com.mif.PSP13uzd.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

  @Mock
  UserRepository userRepository;

  @InjectMocks
  UserService userService;

  @Test
  void testGetdAllUsers() {
    User darbuotojas = new User("Grantas", "Bičiulaitis", "37073518676", "email@gmail.com", "Kauno g. 14", "Labas123!");
    List<User> users = new ArrayList<>();
    users.add(darbuotojas);
    when(userRepository.findAll()).thenReturn(users);
    List<User> found = userService.getAllUsers();
    verify(userRepository).findAll();
    assertEquals(1, found.size());
  }

  @Test
  void testGetUserById() {
    User user = new User("Grantas", "Bičiulaitis", "37073518676", "email@gmail.com", "Kauno g. 14", "Labas123!");
    when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
    User found = userService.getUserById(1L);
    verify(userRepository).findById(Mockito.anyLong());
    assertNotNull(found);
  }

  @Test
  void testSaveUser() {
    User user = new User("Grantas", "Bičiulaitis", "37073518676", "email@gmail.com", "Kauno g. 14", "Labas123!");
    when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
    User added = userService.saveUser(user);
    verify(userRepository).save(Mockito.any(User.class));
    assertNotNull(added);
  }

  @Test
  void testDeleteById() {
    User user = new User("Grantas", "Bičiulaitis", "37073518676", "email@gmail.com", "Kauno g. 14", "Labas123!");
    userService.deleteUserById(1L);
    verify(userRepository).deleteById(Mockito.anyLong());
  }
}