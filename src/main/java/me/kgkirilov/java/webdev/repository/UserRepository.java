package me.kgkirilov.java.webdev.repository;

import me.kgkirilov.java.webdev.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {



}
