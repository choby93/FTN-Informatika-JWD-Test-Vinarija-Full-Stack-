package project.Vinarija.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import project.Vinarija.model.Vino;
import project.Vinarija.repository.VinoRepository;
import project.Vinarija.service.VinoService;

@Service
public class JpaVinoService implements VinoService {

	@Autowired
	private VinoRepository vinoRepository;

	@Override
	public List<Vino> getAll() {
		return vinoRepository.findAll();
	}

	@Override
	public Page<Vino> search(Long vinarijaId, String nazivVina, int pageNo) {
		return vinoRepository.search(vinarijaId, nazivVina, PageRequest.of(pageNo, 3 ));
	}

	@Override
	public Optional<Vino> findOne(Long id) {
		return vinoRepository.findById(id);
	}

	@Override
	public Vino save(Vino vino) {
		return vinoRepository.save(vino);
	}

	@Override
	public Vino delete(Long id) {
		Vino vino = findOne(id).get();

		vinoRepository.delete(vino);
		return vino;

	}

	@Override
	public Vino nabavka(Vino vino, int kolicina) {
		Vino vinoIzmena = findOne(vino.getId()).get();
		if (vinoIzmena != null) {
			int staroStanje = vinoIzmena.getBrojDostupnihFlasa();
			int novoStanje = staroStanje + kolicina;
			vinoIzmena.setBrojDostupnihFlasa(novoStanje);
			vinoRepository.save(vinoIzmena);
			return vinoIzmena;
		}
		return null;
	}

	@Override
	public Vino kupovina(Vino vino, int kolicina) {
		Vino vinoIzmena = findOne(vino.getId()).get();
		if (vinoIzmena != null) {
			int staroStanje = vinoIzmena.getBrojDostupnihFlasa();
			int novoStanje = staroStanje - kolicina;
			vinoIzmena.setBrojDostupnihFlasa(novoStanje);
			vinoRepository.save(vinoIzmena);
			return vinoIzmena;
		}

		return null;
	}

}
