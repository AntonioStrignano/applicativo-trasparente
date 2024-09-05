package it.trasp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.trasp.app.model.Scuola;

public interface ScuolaRepository extends JpaRepository<Scuola, Integer> {

}
