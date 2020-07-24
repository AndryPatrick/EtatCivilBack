import java.util.Scanner;

public class GenererCIN {
	static Scanner sc = new Scanner(System.in);
	public static String sexe;
	static String lieuDelivrance;
	static String sexePers;
	static int codeLieu = 0;
	static int codeSexe = 0;
	
	String generationCIN () {
		int valeur = 26159;
		 valeur += 1;
		 String resultat = null;
		if (lieuDelivrance.matches("Ambositra") && sexePers.matches("lahy")) {
			int codeLieu = 203;
			int sexePers = 1;
			resultat = "Votre numéro CIN est:"+codeLieu+"01"+sexePers;
		}
		else if (lieuDelivrance.matches("Ambositra") && sexePers.matches("vavy")) {
			int codeLieu = 203;
			int sexePers = 2;
			resultat = "Votre numéro CIN est:"+codeLieu+"01"+sexePers;
		}
		else if (lieuDelivrance.matches("Fianarantsoa") && sexePers.matches("lahy")) {
			int codeLieu = 202;
			int sexePers = 1;
			resultat = "Votre numéro CIN est:"+codeLieu+"01"+sexePers;
		}
		else if (lieuDelivrance.matches("Fianarantsoa") && sexePers.matches("vavy")) {
			int codeLieu = 202;
			int sexePers = 2;
			resultat= "Votre numéro CIN est:"+codeLieu+"01"+sexePers+"0"+valeur;
		}
		return resultat;
		
	}

}
