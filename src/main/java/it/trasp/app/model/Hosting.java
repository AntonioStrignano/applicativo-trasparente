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
@Table(name = "hosting")
public class Hosting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome_hosting", nullable = false, unique = true, columnDefinition = "VARCHAR(28)")
	private String nomeHosting;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeHosting() {
		return nomeHosting;
	}

	public void setNomeHosting(String nomeHosting) {
		this.nomeHosting = nomeHosting;
	}

	public List<Sito> getSiti() {
		return siti;
	}

	public void setSiti(List<Sito> siti) {
		this.siti = siti;
	}

	@OneToMany(mappedBy = "hosting")
	private List<Sito> siti;

}
