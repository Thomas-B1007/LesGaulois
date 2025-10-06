package personnages;

import objets.Chaudron;

public class Druide {
	private String nom;
	private int force;
	private Chaudron chaudron = new Chaudron();
	public String getNom() {
		return nom;
	}
	
	public Druide(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Druide " + nom + " : ";
	}
	
	public void fabriquerPotion(int quantite,int forcePotion) {
		chaudron.remplirChaudron(quantite,forcePotion);
		parler("J'ai concoct� " + quantite + " doses de potion magique. Elle a une force de " + forcePotion + ".");
	}
	
	public void boosterGaulois(Gaulois gaulois) {
		if (chaudron.resterPotion()) {
			if ("Ob�lix".equals(gaulois.getNom())) {
				parler("Non, " + gaulois + " Non !... Et tu le sais tr�s bien !");
			} else {
				int forcePotion = chaudron.prendreLouche();
				gaulois.boirePotion(forcePotion);
				parler("Tiens " + gaulois + " un peu de potion magique.");
			}
		} else {
			parler("D�sol� " + gaulois + "il n'y a plus une seule goutte de potion.");
		}
	}
}
