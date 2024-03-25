package project.Vinarija.web.dto;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class VinoDto {

	private Long id;

	private String ime;
	@Size(max = 120, message = "Maksimalno 120 karaktera!")
	private String opis;
	@Positive(message = "Godina prozizvodnje mora biti pozitivan broj!")
	private Integer godinaProizvodnje;
	@Positive(message = "Cena flaše mora biti pozitivan broj!")
	private Double cenaFlase;

	private Integer brojDostupnihFlasa;

	private Long tipVinaId;

	private String tipVinaIme;

	private Long vinarijaId;

	private String vinarijaIme;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Integer getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	public void setGodinaProizvodnje(Integer godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}

	public Double getCenaFlase() {
		return cenaFlase;
	}

	public void setCenaFlase(Double cenaFlase) {
		this.cenaFlase = cenaFlase;
	}

	public Integer getBrojDostupnihFlasa() {
		return brojDostupnihFlasa;
	}

	public void setBrojDostupnihFlasa(Integer brojDostupnihFlasa) {
		this.brojDostupnihFlasa = brojDostupnihFlasa;
	}

	public Long getTipVinaId() {
		return tipVinaId;
	}

	public void setTipVinaId(Long tipVinaId) {
		this.tipVinaId = tipVinaId;
	}

	public String getTipVinaIme() {
		return tipVinaIme;
	}

	public void setTipVinaIme(String tipVinaIme) {
		this.tipVinaIme = tipVinaIme;
	}

	public Long getVinarijaId() {
		return vinarijaId;
	}

	public void setVinarijaId(Long vinarijaId) {
		this.vinarijaId = vinarijaId;
	}

	public String getVinarijaIme() {
		return vinarijaIme;
	}

	public void setVinarijaIme(String vinarijaIme) {
		this.vinarijaIme = vinarijaIme;
	}

}
