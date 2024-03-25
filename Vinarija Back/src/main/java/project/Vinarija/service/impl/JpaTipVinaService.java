package project.Vinarija.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import project.Vinarija.model.TipVina;
import project.Vinarija.repository.TipVinaRepository;
import project.Vinarija.service.TIpVinaService;

@Service
public class JpaTipVinaService implements TIpVinaService {

	@Autowired
	private TipVinaRepository tipRepo;

	@Override
	@PreAuthorize("permitAll()")
	public List<TipVina> getAll() {
		return tipRepo.findAll();
	}

	@Override
	public Optional<TipVina> findOne(Long tipVinaId) {
		return tipRepo.findById(tipVinaId);
	}

}
