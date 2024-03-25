package project.Vinarija.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.Vinarija.model.Vinarija;

@Repository
public interface VinarijaRepository extends JpaRepository<Vinarija, Long> {

}
