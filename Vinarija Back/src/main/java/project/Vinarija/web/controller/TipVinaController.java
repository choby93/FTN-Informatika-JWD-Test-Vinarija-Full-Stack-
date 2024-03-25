package project.Vinarija.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.Vinarija.model.TipVina;
import project.Vinarija.service.TIpVinaService;
import project.Vinarija.support.TipVinaToTIpVinaDto;
import project.Vinarija.web.dto.TipVInaDto;

@RestController
@RequestMapping(value = "/api/tipovi", produces = MediaType.APPLICATION_JSON_VALUE)
public class TipVinaController {

	@Autowired
	private TIpVinaService tipService;

	@Autowired
	private TipVinaToTIpVinaDto tipToDto;

	@GetMapping
	@PreAuthorize("permitAll()")
	public ResponseEntity<List<TipVInaDto>> getAll() {
		List<TipVina> tipovi = tipService.getAll();
		return new ResponseEntity<>(tipToDto.convert(tipovi), HttpStatus.OK);
	}

}
