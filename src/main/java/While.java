import java.util.Scanner;

public class While {

	public static void main(String[] args) {
		String prenom;
		char reponse = 'O';
		Scanner sc = new Scanner(System.in);
		while (reponse == 'O') {
			System.out.println("Donnez un prénom : ");
			prenom = sc.nextLine();
			System.out.println("Bonjour " + prenom + ", comment vas-tu ?");
			// Sans ça, nous n'entrerions pas dans la deuxième boucle
			reponse = ' ';
			// Tant que la réponse n'est pas O ou N, on repose la question
			while (reponse != 'O' && reponse != 'N') {
				// On demande si la personne veut faire un autre essai
				System.out.println("Voulez-vous réessayer ? (O/N)");
				reponse = sc.nextLine().charAt(0);
			}
		}
		System.out.println("Au revoir...");
	}
}
