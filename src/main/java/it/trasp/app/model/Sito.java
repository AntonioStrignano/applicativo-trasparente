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

@Entity
@Table(name = "sito")
public class Sito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "dominio", nullable = false, columnDefinition = "TINYTEXT")
	@NotBlank(message = "Inserisci l'URL del dominio a cui fa riferimento il sito.")
	private String dominio;

	@Column(name = "sottodominio", nullable = true, columnDefinition = "TINYTEXT")
	private String sottodominio;

	@Column(name = "db_sito", nullable = true, columnDefinition = "TINYTEXT")
	private String dbSito;

	@Column(name = "db_user", nullable = true, columnDefinition = "TINYTEXT")
	private String dbUser;

	@Column(name = "db_user_pswd", nullable = true, columnDefinition = "TINYTEXT")
	private String dbUserPswd;

	@ManyToOne
	@JoinColumn(name = "id_hosting", nullable = true, columnDefinition = "INTEGER(4)")
	private Hosting hosting;

	@OneToMany(mappedBy="sitoScuola")
	private List<Scuola> scuoleSito;

	public List<Scuola> getScuoleSito() {
		return scuoleSito;
	}

	public void setScuoleSito(List<Scuola> scuoleSito) {
		this.scuoleSito = scuoleSito;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Scuola> getScuole() {
		return scuoleSito;
	}

	public void setScuole(List<Scuola> scuole) {
		this.scuoleSito = scuole;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getSottodominio() {
		return sottodominio;
	}

	public void setSottodominio(String sottodominio) {
		this.sottodominio = sottodominio;
	}

	public String getDbSito() {
		return dbSito;
	}

	public void setDbSito(String dbSito) {
		this.dbSito = dbSito;
	}

	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbUserPswd() {
		return dbUserPswd;
	}

	public void setDbUserPswd(String dbUserPswd) {
		this.dbUserPswd = dbUserPswd;
	}

	public Hosting getHosting() {
		return hosting;
	}

	public void setHosting(Hosting hosting) {
		this.hosting = hosting;
	}

}
