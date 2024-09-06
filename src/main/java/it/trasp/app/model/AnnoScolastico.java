package it.trasp.app.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="anno_scolastico")
public class AnnoScolastico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="anno_scolastico", nullable = false, columnDefinition = "CHAR(9)" )
	@NotEmpty(message = "Inserisci un anno scolastico.")
	@Pattern(regexp = "^\\d{4}/\\d{4}$", message = "Formato anno scolastico non valido. Deve essere YYYY/YYYY.")
	private String annoScolastico;
	
	@ManyToMany(mappedBy="anniScolastici")
	private List<Documento> documenti;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnnoScolastico() {
		return annoScolastico;
	}

	public void setAnnoScolastico(String annoScolastico) {
		this.annoScolastico = annoScolastico;
	}

	public List<Documento> getDocumenti() {
		return documenti;
	}

	public void setDocumenti(List<Documento> documenti) {
		this.documenti = documenti;
	}
	
	
	
}
