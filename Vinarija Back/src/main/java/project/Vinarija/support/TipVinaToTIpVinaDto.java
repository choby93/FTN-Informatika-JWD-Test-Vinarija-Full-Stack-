package project.Vinarija.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import project.Vinarija.model.TipVina;
import project.Vinarija.web.dto.TipVInaDto;
@Component
public class TipVinaToTIpVinaDto implements Converter<TipVina, TipVInaDto> {

	@Override
	public TipVInaDto convert(TipVina t) {

		TipVInaDto dto = new TipVInaDto();

		dto.setId(t.getId());
		dto.setIme(t.getIme());

		return dto;
	}

	public List<TipVInaDto> convert(List<TipVina> tip) {

		List<TipVInaDto> dtoS = new ArrayList<>();
		for(TipVina t: tip) {
			dtoS.add(convert(t));
		}
		return dtoS;
	}

}
