package com.example.javatutorials.springboot._2_springDATA;

import com.example.javatutorials.springboot._2_springDATA.LoginEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface ILoginRepository{}

/*@Repository
public interface ILoginRepository extends CrudRepository<LoginEntity,Long> {

    //Delivered Query
    LoginEntity findByEmail(String email);
}*/
