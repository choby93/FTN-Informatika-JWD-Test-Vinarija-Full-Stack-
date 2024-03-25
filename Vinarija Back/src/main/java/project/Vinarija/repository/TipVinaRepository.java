package project.Vinarija.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.Vinarija.model.TipVina;

@Repository
public interface TipVinaRepository extends JpaRepository<TipVina, Long> {

}
