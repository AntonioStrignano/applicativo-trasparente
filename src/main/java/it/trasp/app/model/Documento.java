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
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "documento")
public class Documento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "titolo_record", nullable = false, columnDefinition = "TINYTEXT")
	@NotBlank(message = "Inserisci un titolo.")
	private String titoloRecord;

	@Column(name = "file_documento", columnDefinition = "MEDIUMTEXT")
	private String fileDocumento;

	@Column(name = "titolo_frontend", columnDefinition = "TINYTEXT")
	private String titoloFrontend;

	@Column(name = "tag_anno", columnDefinition = "VARCHAR(30)")
	private String tagAnno;

	@Column(name = "contenuto_testo", columnDefinition = "MEDIUMTEXT")
	private String contenutoTesto;

	@ManyToOne
	@JoinColumn(name = "id_categoria", nullable = false, columnDefinition = "INTEGER(3)")
	@NotNull(message = "Seleziona una categoria")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "id_tabella", columnDefinition = "INTEGER(3)")
	private Tabella tabellaDoc;

	@ManyToOne
	@JoinColumn(name = "id_scuola", nullable = false, columnDefinition = "INTEGER(3)")
	@NotNull(message = "Seleziona una scuola.")
	private Scuola scuola;

	@ManyToMany()
	@JoinTable(name = "doc_annoscol", joinColumns = @JoinColumn(name = "id_documento"), inverseJoinColumns = @JoinColumn(name = "id_annoscol"))
	@NotNull(message = "Seleziona almeno un anno scolastico.")
	private List<AnnoScolastico> anniScolastici;

	@ManyToOne
	@JoinColumn(name = "id_stato")
	private StatoDoc statoDoc;

	public String getTitoloRecord() {
		return titoloRecord;
	}

	public void setTitoloRecord(String titoloRecord) {
		this.titoloRecord = titoloRecord;
	}

	public String getFileDocumento() {
		return fileDocumento;
	}

	public void setFileDocumento(String fileDocumento) {
		this.fileDocumento = fileDocumento;
	}

	public String getTitoloFrontend() {
		return titoloFrontend;
	}

	public void setTitoloFrontend(String titoloFrontend) {
		this.titoloFrontend = titoloFrontend;
	}

	public String getTagAnno() {
		return tagAnno;
	}

	public void setTagAnno(String tagAnno) {
		this.tagAnno = tagAnno;
	}

	public String getContenutoTesto() {
		return contenutoTesto;
	}

	public void setContenutoTesto(String contenutoTesto) {
		this.contenutoTesto = contenutoTesto;
	}

	public Tabella getTabellaDoc() {
		return tabellaDoc;
	}

	public void setTabellaDoc(Tabella tabellaDoc) {
		this.tabellaDoc = tabellaDoc;
	}

	public StatoDoc getStatoDoc() {
		return statoDoc;
	}

	public void setStatoDoc(StatoDoc statoDoc) {
		this.statoDoc = statoDoc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitolo_record() {
		return titoloRecord;
	}

	public void setTitolo_record(String titolo_record) {
		this.titoloRecord = titolo_record;
	}

	public String getFile_documento() {
		return fileDocumento;
	}

	public void setFile_documento(String file_documento) {
		this.fileDocumento = file_documento;
	}

	public String getTitolo_frontend() {
		return titoloFrontend;
	}

	public void setTitolo_frontend(String titolo_frontend) {
		this.titoloFrontend = titolo_frontend;
	}

	public String getTag_anno() {
		return tagAnno;
	}

	public void setTag_anno(String tag_anno) {
		this.tagAnno = tag_anno;
	}

	public String getContenuto_testo() {
		return contenutoTesto;
	}

	public void setContenuto_testo(String contenuto_testo) {
		this.contenutoTesto = contenuto_testo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Tabella getTabella() {
		return tabellaDoc;
	}

	public void setTabella(Tabella tabella) {
		this.tabellaDoc = tabella;
	}

	public Scuola getScuola() {
		return scuola;
	}

	public void setScuola(Scuola scuola) {
		this.scuola = scuola;
	}

	public List<AnnoScolastico> getAnniScolastici() {
		return anniScolastici;
	}

	public void setAnniScolastici(List<AnnoScolastico> anniScolastici) {
		this.anniScolastici = anniScolastici;
	}

}
