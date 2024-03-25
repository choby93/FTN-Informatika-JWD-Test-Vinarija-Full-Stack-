package project.Vinarija.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.Vinarija.model.Vinarija;
import project.Vinarija.service.VinarijaService;
import project.Vinarija.support.VinarijaToVInarijaDto;
import project.Vinarija.web.dto.VinarijaDto;

@RestController
@RequestMapping(value = "/api/vinarije")
public class VinarijaController {

	@Autowired
	private VinarijaService vinarijaService;

	@Autowired
	private VinarijaToVInarijaDto vinarijaToDto;

	@GetMapping
	@PreAuthorize("permitAll()")
	public ResponseEntity<List<VinarijaDto>> getAll() {

		List<Vinarija> vinarije = vinarijaService.getAll();
		return new ResponseEntity<>(vinarijaToDto.convert(vinarije), HttpStatus.OK);
	}

}
