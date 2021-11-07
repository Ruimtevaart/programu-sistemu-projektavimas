package com.mif.PSP13uzd;

import com.mif.PSP13uzd.handler.FunctionHandler;
import com.mif.PSP13uzd.model.User;
import com.mif.PSP13uzd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {

  @Autowired
  FunctionHandler functionHandler;

  private final UserRepository userRepository;

  public Runner(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Autowired
  ConfigurableApplicationContext context;

  @Override
  public void run(String... args) throws Exception {
    populateDB();
    Scanner input = new Scanner(System.in);
    showFunctions();
    int functionId = input.nextInt();
    runLoop: while(functionId != 6){
      switch (functionId){
        case 1:
          functionHandler.addUser();
          break;
        case 2:
          functionHandler.getAllUsers();
          break;
        case 3:
          functionHandler.getUserById();
          break;
        case 4:
          functionHandler.editUserById();
          break;
        case 5:
          functionHandler.deleteUserById();
          break;
        case 6:
          break runLoop;
        default:
          break;
      }
      showFunctions();
      functionId = input.nextInt();
    }
    System.exit(SpringApplication.exit(context));
  }

  private void showFunctions() {
    System.out.println("1.Pridėti vartotoją");
    System.out.println("2.Išvesti visus vartotojus");
    System.out.println("3.Išvesti vartotoją pagal jo ID");
    System.out.println("4.Redaguoti vartotoją pagal jo ID");
    System.out.println("5.Ištrinti vartotoją pagal jo ID");
    System.out.println("6. Baigti darbą");
  }

  private void populateDB(){
    userRepository.save(new User("Grantas", "Bičiulaitis", "37073518676", "email@gmail.com", "Kauno g. 14", "Labas123!"));
    userRepository.save(new User("Vardenis", "Pavardenis", "37012345678", "vardenis.pavardenis@gmail.com", "Vilniaus g. 54", "Paslaptis1!"));
  }
}