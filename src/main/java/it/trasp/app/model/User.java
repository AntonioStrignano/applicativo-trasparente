package it.trasp.app.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@NotNull
	@Column(unique = true)
	@NotBlank(message = "Inserisci username.")
	private String username;

	@NotNull
	@NotBlank(message = "Inserisci password.")
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@NotEmpty(message = "Seleziona almeno un ruolo.")
	@JsonManagedReference
	private List<Role> roles;

	@Column(name = "flag_attivo")
	private Boolean isAttivo;

	@OneToMany(mappedBy = "userDoc")
	@JsonBackReference
	private List<Documento> documenti;
	
	@OneToMany(mappedBy = "userScuola")
	@JsonBackReference
	private List<Scuola> scuoleUser;

	public List<Scuola> getScuole() {
		return scuoleUser;
	}

	public void setScuole(List<Scuola> scuole) {
		this.scuoleUser = scuole;
	}

	// GETTER E SETTER
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Boolean getIsAttivo() {
		return isAttivo;
	}

	public void setIsAttivo(Boolean isAttivo) {
		this.isAttivo = isAttivo;
	}

	public List<Documento> getDocumenti() {
		return documenti;
	}

	public void setDocumenti(List<Documento> documenti) {
		this.documenti = documenti;
	}

}
