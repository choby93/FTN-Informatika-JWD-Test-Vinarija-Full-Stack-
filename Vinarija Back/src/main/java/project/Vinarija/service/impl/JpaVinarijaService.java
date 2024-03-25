package project.Vinarija.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.Vinarija.model.Vinarija;
import project.Vinarija.repository.VinarijaRepository;
import project.Vinarija.service.VinarijaService;

@Service
public class JpaVinarijaService implements VinarijaService {

	@Autowired
	private VinarijaRepository vinarijaRepo;

	@Override
	public List<Vinarija> getAll() {
		return vinarijaRepo.findAll();
	}

	@Override
	public Optional<Vinarija> findOne(Long vinarijaId) {
		return vinarijaRepo.findById(vinarijaId);
	}

}
