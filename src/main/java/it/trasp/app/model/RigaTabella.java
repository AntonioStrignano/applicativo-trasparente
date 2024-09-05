package it.trasp.app.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "righe_tabelle")
public class RigaTabella {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "contenuto_riga", nullable = false)
	private List<String> contenutoRiga;

	@ManyToOne
	@JoinColumn(name = "id_tabella")
	private Tabella tabellaRiga;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<String> getContenutoRiga() {
		return contenutoRiga;
	}

	public void setContenutoRiga(List<String> contenutoRiga) {
		this.contenutoRiga = contenutoRiga;
	}

	public Tabella getTabella() {
		return tabellaRiga;
	}

	public void setTabella(Tabella tabella) {
		this.tabellaRiga = tabella;
	}

}
