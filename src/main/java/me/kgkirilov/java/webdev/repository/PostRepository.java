package me.kgkirilov.java.webdev.repository;

import me.kgkirilov.java.webdev.data.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {



}
