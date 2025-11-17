package personnages;

import objets.Equipement;
import village.Village;

public class Gaulois {
	private String nom;
	//private int force;
	private int effetPotion = 1;
	private Village village;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	@Override
	public String toString() {
		return nom;
	}
	
//	public void frapper(Romain romain) {
//		String nomRomain = romain.getNom();
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + nomRomain);
//		int forceCoup = (force * effetPotion) / 3;
//		romain.recevoirCoup(forceCoup);
//		if (effetPotion > 1) {
//			effetPotion--;
//		}
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " +
		romain.getNom());
		trophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++,nbTrophees++) {
			this.trophees[nbTrophees] = trophees[i];
		}
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix",8);
		System.out.println(asterix);
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public void sePresenter() {
		String debutPhrase = "Bonjour, je m'appelle ";
		if (village == null) {
			parler(debutPhrase + nom + ". Je voyage de villages en villages.");
		} else {
			if (village.getChef() == this) {
				parler(debutPhrase + nom + ". Je suis le chef du village " + village.getNom() + ".");
			} else {
				parler(debutPhrase + nom + ". J'habite au village " + village.getNom() + ".");
			}
		}
	}
}
