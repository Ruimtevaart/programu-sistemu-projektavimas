package com.mif.PSP13uzd.handler;

import com.mif.PSP13uzd.model.User;
import com.mif.PSP13uzd.service.UserService;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FunctionHandler {

  Scanner input = new Scanner(System.in);
  Scanner addressScanner = new Scanner(System.in).useDelimiter("\\n");

  @Autowired
  UserService userService;

  public void addUser() {
    System.out.println("Vardas:");
    String name = input.next();
    System.out.println("Pavardė:");
    String lastName = input.next();
    System.out.println("Telefono numeris:");
    String phoneNumber = input.next();
    System.out.println("El. pašto adresas:");
    String email = input.next();
    System.out.println("Adresas:");
    String address = addressScanner.next();
    System.out.println("Slaptažodis:");
    String password = input.next();
    User user = new User(name, lastName, phoneNumber, email, address, password);
//    User user = new User("Qwerty", "Asdfg", "37068932485", "email@gmail.com", "Labas g. 48", "Paslaptis1!");
    user = userService.saveUser(user);
    System.out.println("---------------------------------");
    System.out.println("Vartotojas " + user.getId() + " išsaugotas sėkmingai");
    System.out.println("---------------------------------");
  }

  public void getAllUsers() {
    System.out.println("-------------------------------------------------------------------------------------------");
    List<User> userList = userService.getAllUsers();
    userList.forEach(user -> System.out.println(user.getId() + " " +
      user.getName() + " " +
      user.getLastName() + " " +
      user.getPhoneNumber() + " " +
      user.getEmail() + " " +
      user.getAddress() + " " +
      user.getPassword()));
    System.out.println("-------------------------------------------------------------------------------------------");
  }

  public void getUserById() {
    System.out.println("Įveskite vartotojo id, kurio duomenis norite pamatyti:");
    Long getId = input.nextLong();
    User userById = userService.getUserById(getId);
    if (userById != null) {
      System.out.println("-------------------------------------------------------------------------------------------");
      System.out.println(userById.getId() + " " +
        userById.getName() + " " +
        userById.getLastName() + " " +
        userById.getPhoneNumber() + " " +
        userById.getEmail() + " " +
        userById.getAddress() + " " +
        userById.getPassword());
      System.out.println("-------------------------------------------------------------------------------------------");
    } else {
      System.out.println("Toks vartotojas neegzistuoja");
    }
  }

  public void editUserById() {
    System.out.println("Įveskite vartotojo id, kurio duomenis norite redaguoti:");
    Long editId = input.nextLong();
    User userById = userService.getUserById(editId);
    int editFunction;
    if (userById != null) {
      System.out.println(
        "Pasirinkite, ką norite redaguoti:\n1. Vardas\n2. Pavardė\n3. Telefono numeris\n4. El. paštas\n5. Adresas\n6. Slaptažodis\n7. Baigti redagavimą");
      editFunction = input.nextInt();
      done:
      while (editFunction != 7) {
        switch (editFunction) {
          case 1:
            System.out.println("Įveskite naują vardą:");
            userById.setName(input.next());
            break;
          case 2:
            System.out.println("Įveskite naują pavardę:");
            userById.setLastName(input.next());
            break;
          case 3:
            System.out.println("Įveskite naują telefono numerį:");
            userById.setPhoneNumber(input.next());
            break;
          case 4:
            System.out.println("Įveskite naują el. pašto adresą:");
            userById.setEmail(input.next());
            break;
          case 5:
            System.out.println("Įveskite naują adresą:");
            userById.setAddress(addressScanner.next());
            break;
          case 6:
            System.out.println("Įveskite naują slaptažodį:");
            userById.setPassword(input.next());
            break;
          case 7:
            break done;
        }
        System.out.println(
          "Pasirinkite, ką norite redaguoti:\n1. Vardas\n2. Pavardė\n3. Telefono numeris\n4. El. paštas\n5. Adresas\n6. Slaptažodis\n7. Baigti redagavimą");
        editFunction = input.nextInt();
      }
      userById = userService.saveUser(userById);
      System.out.println("---------------------------------");
      System.out.println("Vartotojo " + userById.getId() + " nauji duomenys išsaugoti sėkmingai");
      System.out.println("---------------------------------");
    } else {
      System.out.println("Toks vartotojas neegzistuoja");
    }
  }

  public void deleteUserById() {
    System.out.println("Įveskite vartotojo, kurį norite ištrinti, id, :");
    Long deleteId = input.nextLong();
    User userById = userService.getUserById(deleteId);
    if (userById != null) {
      userService.deleteUserById(deleteId);
    }
    else {
      System.out.println("Toks vartotojas neegzistuoja");
    }
  }
}
