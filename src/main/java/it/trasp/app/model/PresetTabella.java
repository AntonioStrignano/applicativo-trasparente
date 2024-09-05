package it.trasp.app.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "preset_tabella")
public class PresetTabella {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome_preset", nullable = false, columnDefinition = "TINYTEXT", unique = true)
	@NotBlank(message = "Inserisci un nome per questo preset.")
	private String nomePreset;

	@Column(name = "n_colonne", nullable = false, columnDefinition = "INTEGER(16)")
	@Size(min=1, max=16, message = "Inserisci un numero compreso tra 1 e 16.")
	private Integer nColonne;

	@Column(name = "header", nullable = false, unique = true)
	private List<String> header;

	@OneToMany(mappedBy = "preset")
	private List<Tabella> tabellePreset;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomePreset() {
		return nomePreset;
	}

	public void setNomePreset(String nomePreset) {
		this.nomePreset = nomePreset;
	}

	public Integer getnColonne() {
		return nColonne;
	}

	public void setnColonne(Integer nColonne) {
		this.nColonne = nColonne;
	}

	public List<String> getHeader() {
		return header;
	}

	public void setHeader(List<String> header) {
		this.header = header;
	}

	public List<Tabella> getTabellePreset() {
		return tabellePreset;
	}

	public void setTabellePreset(List<Tabella> tabellePreset) {
		this.tabellePreset = tabellePreset;
	}

}
