package it.trasp.app.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="regione")
public class Regione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="nome_regione", nullable = false, columnDefinition = "VARCHAR(19)", unique = true)
	private String nomeRegione;
	
	@OneToMany(mappedBy="regione")
	private List<Comune> comuni;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeRegione() {
		return nomeRegione;
	}

	public void setNomeRegione(String nomeRegione) {
		this.nomeRegione = nomeRegione;
	}

	public List<Comune> getComuni() {
		return comuni;
	}

	public void setComuni(List<Comune> comuni) {
		this.comuni = comuni;
	}
	
	
	
	
}
