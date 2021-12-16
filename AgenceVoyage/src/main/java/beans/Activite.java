package beans;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="activite")
@Data
@Setter
@Getter
public class Activite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nom")
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="Voyage_id",referencedColumnName="id")
	private Voyage voyage;

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
	
}
