package project.Vinarija.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.Vinarija.model.Vino;
import project.Vinarija.service.VinoService;
import project.Vinarija.support.VinoDtoToVino;
import project.Vinarija.support.VinoToVinoDto;
import project.Vinarija.web.dto.NabavkaDto;
import project.Vinarija.web.dto.VinoDto;

@RestController
@RequestMapping(value = "/api/vina", produces = MediaType.APPLICATION_JSON_VALUE)
public class VinoController {

	@Autowired
	private VinoService vinoService;
	@Autowired
	private VinoToVinoDto vinoToDto;
	@Autowired
	private VinoDtoToVino toVino;

	@PreAuthorize("permitAll()")
	@GetMapping
	public ResponseEntity<List<VinoDto>> getAll(@RequestParam(required = false, defaultValue = "0") int pageNo,
			@RequestParam(required = false) String nazivVina, @RequestParam(required = false) Long vinarijaId) {

		Page<Vino> page = vinoService.search(vinarijaId, nazivVina, pageNo);
		HttpHeaders headers = new HttpHeaders();
		headers.add("total-pages", Integer.toString(page.getTotalPages()));

		return new ResponseEntity<>(vinoToDto.convert(page.getContent()), headers, HttpStatus.OK);
	}

	@PreAuthorize("permitAll()")
	@GetMapping("/{id}")
	public ResponseEntity<VinoDto> getOne(@PathVariable Long id) {

		Vino vino = vinoService.findOne(id).get();
		if (vino != null) {
			return new ResponseEntity<>(vinoToDto.convert(vino), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VinoDto> create(@RequestBody @Valid VinoDto vinoDto) {

		Vino vino = toVino.convert(vinoDto);
		Vino saved = vinoService.save(vino);
		return new ResponseEntity<>(vinoToDto.convert(saved), HttpStatus.OK);
	}

//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VinoDto> update(@PathVariable Long id, @Valid @RequestBody VinoDto vinoDto) {

		if (vinoDto.getId() != id) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Vino vino = toVino.convert(vinoDto);
		Vino saved = vinoService.save(vino);

		return new ResponseEntity<>(vinoToDto.convert(saved), HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<VinoDto> delete(@PathVariable Long id) {

		Vino deletedVino = vinoService.delete(id);

		if (deletedVino != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/{id}/nabavka")
	public ResponseEntity<VinoDto> nabavkaVina(@PathVariable Long id, @Valid @RequestBody NabavkaDto nabavkaDto) {
		Vino vino = vinoService.findOne(id).get();

		if (vino == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		int kolicina = nabavkaDto.getKolicinaZaIzmenu();
		vinoService.nabavka(vino, kolicina);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_KORISNIK')")
	@PutMapping(value = "/{id}/kupovina")
	public ResponseEntity<VinoDto> kupovinaVina(@PathVariable Long id, @Valid @RequestBody NabavkaDto nabavkaDto) {
		Vino vino = vinoService.findOne(id).get();
		
		if(vino == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		int kolicina = nabavkaDto.getKolicinaZaIzmenu();
		vinoService.kupovina(vino, kolicina);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
}
