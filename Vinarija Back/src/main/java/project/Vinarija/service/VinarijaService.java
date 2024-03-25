package project.Vinarija.service;

import java.util.List;
import java.util.Optional;

import project.Vinarija.model.Vinarija;

public interface VinarijaService {

	List<Vinarija> getAll();

	Optional<Vinarija> findOne(Long vinarijaId);

}
