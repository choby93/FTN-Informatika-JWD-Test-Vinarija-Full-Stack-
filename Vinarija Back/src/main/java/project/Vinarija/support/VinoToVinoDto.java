package project.Vinarija.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import project.Vinarija.model.Vino;
import project.Vinarija.web.dto.VinoDto;

@Component
public class VinoToVinoDto implements Converter<Vino, VinoDto> {
	@Override
	public VinoDto convert(Vino v) {
		VinoDto dto = new VinoDto();

		dto.setId(v.getId());
		dto.setIme(v.getIme());
		dto.setOpis(v.getOpis());
		dto.setGodinaProizvodnje(v.getGodinaProizvodnje());
		dto.setCenaFlase(v.getCenaFlase());
		dto.setBrojDostupnihFlasa(v.getBrojDostupnihFlasa());
		dto.setTipVinaId(v.getTipVina().getId());
		dto.setTipVinaIme(v.getTipVina().getIme());
		dto.setVinarijaId(v.getVinarija().getId());
		dto.setVinarijaIme(v.getVinarija().getIme());

		return dto;
	}

	public List<VinoDto> convert(List<Vino> vino) {

		List<VinoDto> dtoS = new ArrayList<>();

		for (Vino v : vino) {
			dtoS.add(convert(v));
		}
		return dtoS;
	}

}
