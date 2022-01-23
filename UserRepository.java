package com.javacodegeeks.examples.repository;





import org.springframework.data.jpa.repository.JpaRepository;

import com.javacodegeeks.examples.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public void  save(UserRepository userRepository);
}
