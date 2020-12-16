package com.example.freindlist.repository;

import com.example.freindlist.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {

    //User findOne(Integer id);
}
