package it.trasp.app.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "scuola")
public class Scuola {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "win", nullable = true, unique = true, columnDefinition = "INTEGER(8)")
	private Integer win;

	@Column(name = "nome_scuola", nullable = false, unique = true, columnDefinition = "TINYTEXT")
	@NotBlank(message = "Nome scuola obbligatorio.")
	private String nomeScuola;

	@Column(name = "commento", nullable = true)
	private String commento;

	@ManyToOne
	@JoinColumn(name = "id_comune", nullable = false, columnDefinition = "INTEGER(4)")
	@NotNull(message = "Seleziona un Comune.")
	private Comune comune;

	@ManyToOne
	@JoinColumn(name = "id_sito")
	@NotNull(message = "Seleziona un sito web.")
	private Sito sitoScuola;

	@OneToMany(mappedBy = "scuola")
	private List<Documento> documentiScuola;

	@ManyToMany
	@JoinTable(name = "scuole_sezioni", joinColumns = @JoinColumn(name = "id_scuola"), inverseJoinColumns = @JoinColumn(name = "id_sezione"))
	private List<Sezione> sezioni;

	@ManyToMany
	@JoinTable(name = "scuole_users", joinColumns = @JoinColumn(name = "id_scuola"), inverseJoinColumns = @JoinColumn(name = "id_user"))
	private List<User> users;

	public String getCommento() {
		return commento;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}

	public Sito getSitoScuola() {
		return sitoScuola;
	}

	public void setSitoScuola(Sito sitoScuola) {
		this.sitoScuola = sitoScuola;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Documento> getDocumentiScuola() {
		return documentiScuola;
	}

	public void setDocumentiScuola(List<Documento> documentiScuola) {
		this.documentiScuola = documentiScuola;
	}

	public List<Sezione> getSezioni() {
		return sezioni;
	}

	public void setSezioni(List<Sezione> sezioni) {
		this.sezioni = sezioni;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWin() {
		return win;
	}

	public void setWin(Integer win) {
		this.win = win;
	}

	public String getNomeScuola() {
		return nomeScuola;
	}

	public void setNomeScuola(String nomeScuola) {
		this.nomeScuola = nomeScuola;
	}

	public String getSottotitolo() {
		return commento;
	}

	public void setSottotitolo(String sottotitolo) {
		this.commento = sottotitolo;
	}

	public Comune getComune() {
		return comune;
	}

	public void setComune(Comune comune) {
		this.comune = comune;
	}

	public Sito getSito() {
		return sitoScuola;
	}

	public void setSito(Sito sito) {
		this.sitoScuola = sito;
	}

}
