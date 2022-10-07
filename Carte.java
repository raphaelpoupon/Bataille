public class Carte {
	
	private final int couleur;
	private final int valeur;
	
	public Carte(int couleur, int valeur) {
		this.couleur = couleur;
		this.valeur = valeur;
	}
	
	// Permet une représentation texte de la carte avec sa valeur et sa couleur (ex: Deux de coeur)
	public String toString() {
		return Bataille.valeurs[this.valeur-1] + " de " + Bataille.couleurs[this.couleur];
	}
	
	// Un tour, chaque joueur pose une carte, et les points sont attribué au joueur ayant posé la carte la plus puissante, si égalité : aucun point attribué
	public static void play(Joueur j1, Joueur j2) {
		int valueOfJ1Card = j1.putCard().valeur;
		int valueOfJ2Card = j2.putCard().valeur;
		
		if(valueOfJ1Card > valueOfJ2Card)
			j1.addPoints(valueOfJ1Card + valueOfJ2Card);
		else if(valueOfJ1Card < valueOfJ2Card)
			j2.addPoints(valueOfJ1Card + valueOfJ2Card);
		else
			System.out.println("Égalité, aucun joueur ne remporte de point.");
		System.out.println("(" + j1.getName() + " : " + j1.getNbOfPoints() + " point" + (j1.getNbOfPoints()>1?"s":"") + "; " + j2.getName() + " : " + j2.getNbOfPoints() + " point" + (j2.getNbOfPoints()>1?"s":"") + ")");
	}
	
}
