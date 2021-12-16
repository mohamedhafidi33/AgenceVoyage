package beans;

import java.sql.Blob;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data @AllArgsConstructor
public class Voyage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name="dateDepart")
	private Date dateDepart;
	
	@Column(name="description")
	private String description;
	
	@Column(name="prix")
	private double prix;
	
	@Lob
	@Column(name="image")
	private Blob image;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="Confort")
	@Enumerated(EnumType.STRING)
	private Confort confort;
	
	@Column(name="difficulte")
	@Enumerated(EnumType.STRING)
	private Difficulte difficulte;
	
	@Column(name="theme")
	@Enumerated(EnumType.STRING)
	private Theme theme;
	
	@Column(name="dure")
	@Enumerated(EnumType.STRING)
	private Dure dure;
	
	@Column(name="typeVoyage")
	@Enumerated(EnumType.STRING)
	private TypeVoyage typeVoyage;
	
	@OneToMany(mappedBy="voyage")
	private List<Hebergement> hebergements;
	
	@OneToMany(mappedBy="voyage")
	private List<Reservation> reservations;
	
	@OneToMany(mappedBy="voyage")
	private List<Activite> activites;
	
	@OneToMany(mappedBy="voyage")
	private List<Transport> transports;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Confort getConfort() {
		return confort;
	}

	public void setConfort(Confort confort) {
		this.confort = confort;
	}

	public Difficulte getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(Difficulte difficulte) {
		this.difficulte = difficulte;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Dure getDure() {
		return dure;
	}

	public void setDure(Dure dure) {
		this.dure = dure;
	}

	public TypeVoyage getTypeVoyage() {
		return typeVoyage;
	}

	public void setTypeVoyage(TypeVoyage typeVoyage) {
		this.typeVoyage = typeVoyage;
	}

	public List<Hebergement> getHebergements() {
		return hebergements;
	}

	public void setHebergements(List<Hebergement> hebergements) {
		this.hebergements = hebergements;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<Activite> getActivites() {
		return activites;
	}

	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}

	public List<Transport> getTransports() {
		return transports;
	}

	public void setTransports(List<Transport> transports) {
		this.transports = transports;
	}

	
	
}
