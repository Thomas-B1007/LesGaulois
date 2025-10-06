package village;

import personnages.Gaulois;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois chef;
	private Gaulois[] villageois;
	
	public Village(String nom, Gaulois chef, final int NB_VILLAGEOIS_MAX) {
		villageois = new Gaulois[NB_VILLAGEOIS_MAX];
		this.nom = nom;
		this.chef = chef;
		chef.setVillage(this);
	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
		gaulois.setVillage(this);
	}
	
	public Gaulois trouverVillageois(int numVillageois) {
		if (numVillageois <= nbVillageois + 1) {
			return villageois[numVillageois - 1];
		} else {
			System.out.println("Il n’y a pas autant d’habitants dans notre village !");
			return null;
		}
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village \"" + nom + "\" du chef " + chef + " vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("-" + villageois[i]);
		}
	}
	
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", abraracourcix, 30);
		Gaulois gaulois = village.trouverVillageois(30);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);
		gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterVillageois(obelix);
		village.afficherVillageois();
		Gaulois doublepolemix = new Gaulois("DoublePolémix", 4);
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublepolemix.sePresenter();
	}
}
