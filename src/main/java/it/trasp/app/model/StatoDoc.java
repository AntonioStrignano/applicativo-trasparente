package it.trasp.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "stato_doc")
public class StatoDoc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome_stato", nullable = false, columnDefinition = "VARCHAR(10)")
	@NotBlank(message = "Inserisci il nome di questo stato.")
	private String nomeStato;

}
