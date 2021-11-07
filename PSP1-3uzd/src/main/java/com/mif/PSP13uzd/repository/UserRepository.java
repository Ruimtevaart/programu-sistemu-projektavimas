package com.mif.PSP13uzd.repository;

import com.mif.PSP13uzd.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
