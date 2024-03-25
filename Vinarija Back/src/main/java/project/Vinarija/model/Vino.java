package project.Vinarija.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String ime;
	@Column
	private String opis;
	@Column(nullable = false)
	private int godinaProizvodnje;
	@Column
	private double cenaFlase;
	@Column
	private int brojDostupnihFlasa;
	@ManyToOne
	private TipVina tipVina;
	@ManyToOne
	private Vinarija vinarija;

	public Vino() {
		super();
	}

	public Vino(Long id, String ime, String opis, int godinaProizvodnje, double cenaFlase, int brojDostupnihFlasa,
			TipVina tipVina, Vinarija vinarija) {
		super();
		this.id = id;
		this.ime = ime;
		this.opis = opis;
		this.godinaProizvodnje = godinaProizvodnje;
		this.cenaFlase = cenaFlase;
		this.brojDostupnihFlasa = brojDostupnihFlasa;
		this.tipVina = tipVina;
		this.vinarija = vinarija;
	}

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

	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}

	public double getCenaFlase() {
		return cenaFlase;
	}

	public void setCenaFlase(double cenaFlase) {
		this.cenaFlase = cenaFlase;
	}

	public int getBrojDostupnihFlasa() {
		return brojDostupnihFlasa;
	}

	public void setBrojDostupnihFlasa(int brojDostupnihFlasa) {
		this.brojDostupnihFlasa = brojDostupnihFlasa;
	}

	public TipVina getTipVina() {
		return tipVina;
	}

	public void setTipVina(TipVina tipVina) {
		this.tipVina = tipVina;
	}

	public Vinarija getVinarija() {
		return vinarija;
	}

	public void setVinarija(Vinarija vinarija) {
		this.vinarija = vinarija;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vino other = (Vino) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
