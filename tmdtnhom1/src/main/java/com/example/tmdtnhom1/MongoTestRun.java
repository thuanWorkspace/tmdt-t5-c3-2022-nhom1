package com.example.tmdtnhom1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.tmdtnhom1.model.User;
import com.example.tmdtnhom1.repository.UserRepository;

@SpringBootApplication
public class MongoTestRun implements CommandLineRunner {

  @Autowired
  private UserRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(MongoTestRun.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

//    repository.deleteAll();
//
//    // save a couple of customers
//    repository.save(new Customer("Alice", "Smith"));
//    repository.save(new Customer("Bob", "Smith"));

    // fetch all customers
    System.out.println("Customers found with findAll():");
    System.out.println("-------------------------------");
    for (User user : repository.findAll()) {
      System.out.println(user);
    }
    System.out.println();

//    // fetch an individual customer
//    System.out.println("Customer found with findByFirstName('Alice'):");
//    System.out.println("--------------------------------");
//    System.out.println(repository.findByFirstName("Alice"));
//
//    System.out.println("Customers found with findByLastName('Smith'):");
//    System.out.println("--------------------------------");
//    for (Customer customer : repository.findByLastName("Smith")) {
//      System.out.println(customer);
//    }

  }

}