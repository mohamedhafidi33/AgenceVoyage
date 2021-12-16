package beans;


import javax.persistence.*;

import lombok.*;

@Entity
@Data
public class Hebergement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="nom")
	private String nom;
	
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

	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}

	@ManyToOne
	@JoinColumn(name="Voyage_id",referencedColumnName="id")
	private Voyage voyage;
	
}
