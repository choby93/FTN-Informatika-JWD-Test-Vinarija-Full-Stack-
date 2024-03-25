package project.Vinarija.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import project.Vinarija.model.Vinarija;
import project.Vinarija.web.dto.VinarijaDto;

@Component
public class VinarijaToVInarijaDto implements Converter<Vinarija, VinarijaDto> {

	@Override
	public VinarijaDto convert(Vinarija v) {

		VinarijaDto dto = new VinarijaDto();

		dto.setId(v.getId());
		dto.setIme(v.getIme());
		dto.setGodinaOsnivanja(v.getGodinaOsnivanja());

		return dto;
	}

	public List<VinarijaDto> convert(List<Vinarija> vinarija) {
		List<VinarijaDto> dtoS = new ArrayList<>();
		for (Vinarija v : vinarija) {
			dtoS.add(convert(v));
		}
		return dtoS;
	}
}
