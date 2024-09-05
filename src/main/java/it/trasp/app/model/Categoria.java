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
@Table(name="categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="nome_categoria", nullable = false, unique = true, columnDefinition = "TINYTEXT")
	@NotBlank(message = "Inserisci il nome della categoria.")
	private String nomeCategoria;

	@ManyToOne
	@JoinColumn(name="id_gruppo")
	@NotNull(message = "Seleziona un gruppo in cui inserire questa categoria.")
	private GruppoCategoria gruppoCategoria;
	
	@OneToMany(mappedBy="categoria")
	private List<Documento> documentiCategoria;
	
	public List<Documento> getDocumentiCategoria() {
		return documentiCategoria;
	}

	public void setDocumentiCategoria(List<Documento> documentiCategoria) {
		this.documentiCategoria = documentiCategoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public GruppoCategoria getGruppoCategoria() {
		return gruppoCategoria;
	}

	public void setGruppoCategoria(GruppoCategoria gruppoCategoria) {
		this.gruppoCategoria = gruppoCategoria;
	}
	
	
	
}
