package it.trasp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.trasp.app.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
