package it.trasp.app.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="comune")
public class Comune {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="nome_comune", nullable = false, unique = true, columnDefinition = "VARCHAR(35)")
	@NotBlank(message = "Inserisci il nome del comune.")
	private String nomeComune;
	
	@Column(name="provincia", nullable = false, columnDefinition = "VARCHAR(20)")
	@NotBlank(message = "Inserisci la provincia per esteso del comune.")
	private String provincia;
	
	@Column(name="cap", nullable = false, unique = true, columnDefinition = "INTEGER(5)")
	@NotEmpty(message = "Inserisci il CAP del comune")
	@Size(min = 5, max = 5, message = "Inserisci un numero composto da 5 cifre.")
	private Integer cap;
	
	@ManyToOne
	@JoinColumn(name="id_regione", nullable = false, columnDefinition = "INTEGER(2)")
	@NotNull(message = "Seleziona la regione in cui si trova il comune.")
	private Regione regione;
	
	@OneToMany(mappedBy="comune")
	private List<Scuola> scuoleComune;

	public List<Scuola> getScuole() {
		return scuoleComune;
	}

	public void setScuole(List<Scuola> scuole) {
		this.scuoleComune = scuole;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeComune() {
		return nomeComune;
	}

	public void setNomeComune(String nomeComune) {
		this.nomeComune = nomeComune;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Integer getCap() {
		return cap;
	}

	public void setCap(Integer cap) {
		this.cap = cap;
	}

	public Regione getRegione() {
		return regione;
	}

	public void setRegione(Regione regione) {
		this.regione = regione;
	}
	
}
