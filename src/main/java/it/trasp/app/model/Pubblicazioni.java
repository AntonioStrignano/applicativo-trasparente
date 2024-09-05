package it.trasp.app.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pubblicazioni")
public class Pubblicazioni {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "user_record", nullable = false)
	private User userRecord;

	@ManyToOne
	@JoinColumn(name = "doc_record", nullable = false)
	private Documento docRecord;

	@Column(name = "data_pubblicazione", nullable = false)
	private LocalDateTime dataPubblicazione = LocalDateTime.now();

	@Column(name = "is_edit")
	private Boolean isEdit = false;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUserRecord() {
		return userRecord;
	}

	public void setUserRecord(User userRecord) {
		this.userRecord = userRecord;
	}

	public Documento getDocRecord() {
		return docRecord;
	}

	public void setDocRecord(Documento docRecord) {
		this.docRecord = docRecord;
	}

	public LocalDateTime getDataPubblicazione() {
		return dataPubblicazione;
	}

	public void setDataPubblicazione(LocalDateTime dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}

}
