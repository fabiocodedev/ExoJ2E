package Model;

public class Emprunt {
	private Conducteur conducteur;
	private Vehicule vehicule;
	public Emprunt(Conducteur conducteur, Vehicule vehicule) {
		super();
		this.conducteur = conducteur;
		this.vehicule = vehicule;
	}
	public Conducteur getConducteur() {
		return conducteur;
	}
	public void setConducteur(Conducteur conducteur) {
		this.conducteur = conducteur;
	}
	public Vehicule getVehicule() {
		return vehicule;
	}
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
}

