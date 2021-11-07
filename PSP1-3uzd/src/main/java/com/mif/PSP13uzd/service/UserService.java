package com.mif.PSP13uzd.service;

import com.mif.PSP13uzd.model.User;
import com.mif.PSP13uzd.repository.UserRepository;
import com.mif.PSP13uzd.validator.EmailValidator;
import com.mif.PSP13uzd.validator.PasswordChecker;
import com.mif.PSP13uzd.validator.PhoneValidator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public User saveUser(User user) {
    if (validateUser(user)) {
      return userRepository.save(user);
    }
    else return null;
  }

  private boolean validateUser(User user) {
    EmailValidator emailValidator = new EmailValidator();
    PasswordChecker passwordChecker = new PasswordChecker();
    passwordChecker.setMinLength(5);
    passwordChecker.setMaxLength(20);
    PhoneValidator phoneValidator = new PhoneValidator();
    phoneValidator.addCountryValidation("Lithuania", new int[]{8}, "8", "370");//salis, numerio ilgiai be prefix, vietinis prefix, tarptautinis prefix
    boolean emailSuccess = emailValidator.isEmailValid(user.getEmail());
    boolean passwordSuccess = passwordChecker.isPasswordValid(user.getPassword());
    boolean phoneSuccess = phoneValidator.isPhoneNumberValid(user.getPhoneNumber(),"Lithuania");
    if (!emailSuccess) {
      System.out.println("------------------");
      System.out.println("ERROR VALIDATING EMAIL");
      System.out.println("------------------");
    }
    if (!passwordSuccess) {
      System.out.println("------------------");
      System.out.println("ERROR VALIDATING PASSWORD");
      System.out.println("------------------");
    }
    if (!phoneSuccess) {
      System.out.println("------------------");
      System.out.println("ERROR VALIDATING PHONE");
      System.out.println("------------------");
    }
    return emailSuccess && passwordSuccess && phoneSuccess;
  }

  public List<User> getAllUsers() {
    return (List<User>) userRepository.findAll();
  }

  public User getUserById(Long id) {
    Optional<User> user = userRepository.findById(id);
    if (user.isPresent()) return user.get();
    else return null;
  }

  public void deleteUserById(Long id) {
    userRepository.deleteById(id);
  }
}
