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
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tabella")
public class Tabella {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome_tabella", columnDefinition = "TINYTEXT", unique = true, nullable = false)
	@NotBlank(message = "Il nome della tabella è obbligatorio.")
	private String nomeTabella;

	@ManyToOne
	@JoinColumn(name = "id_preset")
	@NotNull(message = "Seleziona un preset.")
	private PresetTabella preset;

	@OneToMany(mappedBy = "tabellaRiga")
	private List<RigaTabella> righeTabella;
	
	@OneToMany(mappedBy="tabellaDoc")
	private List<Documento> documentiTabella;

	public List<Documento> getDocumentiTabella() {
		return documentiTabella;
	}

	public void setDocumentiTabella(List<Documento> documentiTabella) {
		this.documentiTabella = documentiTabella;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeTabella() {
		return nomeTabella;
	}

	public void setNomeTabella(String nomeTabella) {
		this.nomeTabella = nomeTabella;
	}

	public PresetTabella getPresetTabella() {
		return preset;
	}

	public void setPresetTabella(PresetTabella presetTabella) {
		this.preset = presetTabella;
	}

	public List<RigaTabella> getRigheTabella() {
		return righeTabella;
	}

	public void setRigheTabella(List<RigaTabella> righeTabella) {
		this.righeTabella = righeTabella;
	}

}
