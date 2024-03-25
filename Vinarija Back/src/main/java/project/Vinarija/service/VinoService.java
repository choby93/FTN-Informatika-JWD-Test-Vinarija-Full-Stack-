package project.Vinarija.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import project.Vinarija.model.Vino;

public interface VinoService {

	Page<Vino> search(Long vinarijaId, String nazivVina, int pageNo);

	Optional<Vino> findOne(Long id);

	Vino save(Vino vino);

	Vino delete(Long id);

	List<Vino> getAll();

	Vino nabavka(Vino vino, int kolicina);

	Vino kupovina(Vino vino, int kolicina);

}
