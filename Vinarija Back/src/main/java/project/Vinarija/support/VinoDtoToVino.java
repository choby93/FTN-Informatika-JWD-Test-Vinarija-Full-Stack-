package project.Vinarija.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import project.Vinarija.model.Vino;
import project.Vinarija.service.TIpVinaService;
import project.Vinarija.service.VinarijaService;
import project.Vinarija.service.VinoService;
import project.Vinarija.web.dto.VinoDto;

@Component
public class VinoDtoToVino implements Converter<VinoDto, Vino> {

	@Autowired
	private VinoService vinoService;
	@Autowired
	private TIpVinaService tIpVinaService;
	@Autowired
	private VinarijaService vinarijaService;

	@Override
	public Vino convert(VinoDto dto) {

		Vino vino;
		if (dto.getId() == null) {
			vino = new Vino();
		} else {
			vino = vinoService.findOne(dto.getId()).get();
		}

		if (vino != null) {
			vino.setId(dto.getId());
			vino.setIme(dto.getIme());
			vino.setOpis(dto.getOpis());
			vino.setGodinaProizvodnje(dto.getGodinaProizvodnje());
			vino.setCenaFlase(dto.getCenaFlase());
			if(dto.getBrojDostupnihFlasa() == null) {
				vino.setBrojDostupnihFlasa(0);
			}
			vino.setTipVina(tIpVinaService.findOne(dto.getTipVinaId()).get());
			vino.setVinarija(vinarijaService.findOne(dto.getVinarijaId()).get());
		}

		return vino;
	}

}
