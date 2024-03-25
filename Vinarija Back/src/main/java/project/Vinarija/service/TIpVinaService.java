package project.Vinarija.service;

import java.util.List;
import java.util.Optional;

import project.Vinarija.model.TipVina;

public interface TIpVinaService {

	List<TipVina> getAll();

	Optional<TipVina> findOne(Long tipVinaId);

}
