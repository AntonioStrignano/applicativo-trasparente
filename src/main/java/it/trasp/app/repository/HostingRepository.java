package it.trasp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.trasp.app.model.Hosting;

public interface HostingRepository extends JpaRepository<Hosting, Integer> {

}
