package it.trasp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.trasp.app.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
