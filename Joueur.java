import java.util.ArrayList;


public class Joueur {
	
	private ArrayList<Carte> paquet = new ArrayList<Carte>();
	
	private String name;
	
	private int nbOfPoints;
	
	public Joueur(String name) {
		this.name = name;
		this.nbOfPoints = 0;
	}
	
	// Ajout d'une carte au paquet du joueur
	public void addCardToPaquet(Carte carte) {
		this.paquet.add(carte);
	}

	// Remise à zéro du paquet du joueur et de son nombre de point pour recommencer une nouvelle partie
	public void resetPaquet() {
		this.paquet.clear();
		this.nbOfPoints = 0;
	}
	
	// Permet de savoir si le joueur possède encore des cartes
	public boolean paquetIsNotEmpty() {
		return this.paquet.size() > 0;
	}
	
	// Ajout d'un nombre de points au joueur
	public void addPoints(int pointsToAdd) {
		this.nbOfPoints += pointsToAdd;
		System.out.println(this.getName() + " remporte donc " + pointsToAdd + " points.");
	}
	
	public int getNbOfPoints() {
		return this.nbOfPoints;
	}
	
	public String getName() {
		return this.name;
	}
	
	// Ajout d'une carte au paquet du joueur pour la distribution des cartes
	public Carte putCard() {
		Carte cardToPut = paquet.get(this.paquet.size()-1);
		this.paquet.remove(this.paquet.size()-1);
		System.out.print(this.getName() + " joue la carte " + cardToPut.toString() + ", ");
		return cardToPut;
	}

}
