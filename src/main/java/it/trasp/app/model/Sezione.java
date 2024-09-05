package it.trasp.app.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="sezione")
public class Sezione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="titolo_sezione", nullable = false, columnDefinition = "VARCHAR(20)")
	@NotBlank(message = "Inserisci il titolo per questa sezione.")
	private String titoloSezione;
	
	@Column(name = "nota", nullable = true, columnDefinition = "TINYTEXT")
	private String nota;
	
	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	@ManyToMany(mappedBy="sezioni")
	private List<Scuola> scuole;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitoloSezione() {
		return titoloSezione;
	}

	public void setTitoloSezione(String titoloSezione) {
		this.titoloSezione = titoloSezione;
	}

	public List<Scuola> getScuole() {
		return scuole;
	}

	public void setScuole(List<Scuola> scuole) {
		this.scuole = scuole;
	}
	

}
