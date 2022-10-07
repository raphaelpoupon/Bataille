import java.util.ArrayList;
import java.util.Collections;

public class Bataille {
	
	/* Après avoir créé deux joueurs, nous les faisons jouer ensemble jusqu'à ce qu'il y ait une égalité entre les deux
	 * La variable i enregistre le nombre de partie avant d'avoir eu une égalité, nous l'affichons à la fin
	 */
	public static void main(String[] args) {
		
		Joueur j1 = new Joueur("Francis");
		Joueur j2 = new Joueur("Jean");
		
		int i = 0;
		while(Bataille.play(j1, j2)) {
			i++;
		}
		System.out.println("\n\n" + j1.getName() + " et " + j2.getName() + " ont joué " + i + " fois avant d'être à égalité.");

	}
	
	public static String[] couleurs = {"pic", "trèfle", "coeur", "carreau"};
	public static String[] valeurs = {"As", "Deux", "Trois", "Quatre", "Cinq", "Six", "Sept", "Huit", "Neuf", "Dix", "Vallet", "Dame", "Roi"};
	
	// Création d'un paquet de carte classique
	private static ArrayList<Carte> getPacket() {
		ArrayList<Carte> packet = new ArrayList<Carte>();
		for(int couleur = 0; couleur < Bataille.couleurs.length; couleur++) {
			for(int valeur = 1; valeur < Bataille.valeurs.length+1; valeur++) {
				packet.add(new Carte(couleur, valeur));
			}
		}
		return packet;
	}
	
	// Création d'un paquet de carte aléatoire à partir d'un paquet de carte classique
	private static ArrayList<Carte> getRandomPacket() {
		ArrayList<Carte> packet = Bataille.getPacket();
		Collections.shuffle(packet);
		return packet;
	}
	
	// Distribution d'un paquet de cartes aléatoire en retirant toutes les cartes des joueurs
	private static void distribuateRandomPacketFor(Joueur j1, Joueur j2) {
		j1.resetPaquet();
		j2.resetPaquet();
		ArrayList<Carte> packet = Bataille.getRandomPacket();
		for(int cardPosition = 0 ; cardPosition < packet.size(); cardPosition = cardPosition + 2) {
			j1.addCardToPaquet(packet.get(cardPosition));
			j2.addCardToPaquet(packet.get(cardPosition + 1));
		}
	}
	
	// Fin de partie, la fonction compte les points, donne le résultat et renvoie TRUE si les résultats des joueurs sont différents (FALSE sinon)
	private static boolean endGame(Joueur j1, Joueur j2) {
		int totalPointsOfJ1 = j1.getNbOfPoints();
		int totalPointsOfJ2 = j2.getNbOfPoints();
		if(totalPointsOfJ1 != totalPointsOfJ2)
			System.out.println("\n\n--> " + (totalPointsOfJ1>totalPointsOfJ2?(j1.getName() + " gagne avec " + totalPointsOfJ1):(j2.getName() + " gagne avec " + totalPointsOfJ2)) + " points contre " + (totalPointsOfJ1<totalPointsOfJ2?(j1.getName() + " qui en a seulement " + totalPointsOfJ1):(j2.getName() + " qui en a seulement " + totalPointsOfJ2)) + ".");
		else
			System.out.println("\n\n--> Les deux joueurs terminent à égalité avec " + totalPointsOfJ1 + " points.");
		return (totalPointsOfJ1 != totalPointsOfJ2);
	}
	
	// Execute une partie de Bataille, en incluant la distribution des cartes et la fin de partie 
	// La fonction renvoie le booléen renvoyé par la fonction endGame, afin de savoir si c'est une égalité entre les joueurs
	public static boolean play(Joueur j1, Joueur j2) {
		Bataille.distribuateRandomPacketFor(j1, j2);
		int nbOfTurn = 1;
		while(j1.paquetIsNotEmpty()&&j2.paquetIsNotEmpty()) {
			System.out.println("\nTOUR " + nbOfTurn);
			Carte.play(j1, j2);
			nbOfTurn++;
		}
		return Bataille.endGame(j1, j2);
	}

}
