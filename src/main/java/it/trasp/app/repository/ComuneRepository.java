package it.trasp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.trasp.app.model.Comune;

public interface ComuneRepository extends JpaRepository<Comune, Integer> {

}
