package it.trasp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.trasp.app.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
