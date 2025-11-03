package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert (forceCoup >= 0);
		int temp = force;
		force = force - forceCoup;
		if (force <= 0) {
			parler("J'abandonne !");
		} else {
			parler("Aïe !");
		}
		assert (temp > force);
		assert isInvariantVerified();
	}
	
	public void sEquiper(Equipement equipement) {
		String debutPhrase = "Le soldat ";
		switch (nbEquipement) {
		case 1: {
			if (equipement.equals(equipements[0])) {
				System.out.println(debutPhrase + nom + " possède déjà un " + equipement + " !");
			} else {
				equiperEquipement(equipement, debutPhrase);
			}
			break;
		}
		case 0: {
			equiperEquipement(equipement, debutPhrase);
			break;
		}
		default:
			System.out.println(debutPhrase + nom + " est déjà bien protégé !");
		}
	}

	private void equiperEquipement(Equipement equipement, String debutPhrase) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println(debutPhrase + nom + " s'équipe avec un " + equipement + ".");
	}
	
	private boolean isInvariantVerified() {
		return force >= 0;
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
