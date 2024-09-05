package it.trasp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.trasp.app.model.Tabella;

public interface TabellaRepository extends JpaRepository<Tabella, Integer> {

}
