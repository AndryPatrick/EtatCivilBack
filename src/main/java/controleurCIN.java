import java.util.Scanner;

public class controleurCIN {
	
	static Scanner sc = new Scanner(System.in);
	public static String sexe;
	static String lieuDelivrance;
	static String sexePers;
	
  public static void main (String[] args) {
	  GenererCIN generer = new GenererCIN();
	  
	  char response = 'O';
	  Scanner sc = new Scanner(System.in);
	  
	while (response == 'O') {
	  System.out.println("Aiza ianao no mipetraka");
		String lieu = sc.nextLine();
		//int lieuDelivrance = Integer.valueOf(lieu).intValue();
		lieuDelivrance = lieu;

		System.out.println("lahy sa vavy");
		sexe = sc.nextLine();
		sexePers = sexe;
		int valeur = 26159;
		 valeur += 1;
		 String resulat;
		
		 //  CONDITION IF
		/*
		 * if (lieuDelivrance.matches("Ambositra") && sexePers.matches("lahy")) { int
		 * codeLieu = 203; int sexePers = 1;
		 * System.out.println("Votre numéro CIN est:"+codeLieu+"01"+sexePers+"0"+valeur)
		 * ; } else if (lieuDelivrance.matches("Ambositra") && sexePers.matches("vavy"))
		 * { int codeLieu = 203; int sexePers = 2;
		 * System.out.println("Votre numéro CIN est:"+codeLieu+"01"+sexePers+"0"+valeur)
		 * ; } else if (lieuDelivrance.matches("Fianarantsoa") &&
		 * sexePers.matches("lahy")) { int codeLieu = 203; int sexePers = 1;
		 * System.out.println("Votre numéro CIN est:"+codeLieu+"01"+sexePers+"0"+valeur)
		 * ; } else if (lieuDelivrance.matches("Fianarantsoa") &&
		 * sexePers.matches("vavy")) { int codeLieu = 202; int sexePers = 2;
		 * System.out.println("Votre numéro CIN est:"+codeLieu+"01"+sexePers+"0"+valeur)
		 * ; }
		 */
		 
		 
		 //  CONDITION SWITCH et WHILE
		 int codeLieu;
		 switch (lieuDelivrance)
		 {
		 	case "Ambositra":
		 		 codeLieu = 203;
		 			if (sexePers.matches("lahy")) {
		 				int sexePers = 1;
		 				System.out.println("CIN numéro: "+codeLieu+"01"+sexePers+"0"+valeur);
		 			}
		 			else {
		 				int sexePers = 2;
		 				System.out.println("CIN numéro: "+codeLieu+"01"+sexePers+"0"+valeur);
		 			}
		 		break;
		 		
		 	case "Fianarantsoa":
		 		 codeLieu = 202;
		 		if (sexePers.matches("lahy")) {
	 				int sexePers = 1;
	 				System.out.println("CIN numéro: "+codeLieu+"01"+sexePers+"0"+valeur);
	 			}
	 			else {
	 				int sexePers = 2;
	 				System.out.println("CIN numéro: "+codeLieu+"01"+sexePers+"0"+valeur);
	 			}
	 		break;
	 		
		 	case "Ambatofinandrahana":
		 		 codeLieu = 201;
		 		if (sexePers.matches("lahy")) {
	 				int sexePers = 1;
	 				System.out.println("CIN numéro: "+codeLieu+" 01"+sexePers+" 0"+valeur);
	 			}
	 			else {
	 				int sexePers = 2;
	 				System.out.println("CIN numéro: "+codeLieu+"01"+sexePers+"0"+valeur);
	 			}
	 		break;
	 		default:
	 			System.out.println("Tsy mamoaka karatra tompoko ny faritra " +lieuDelivrance);
	 			
	 			
		 } 		 
		 response = ' ';
		 	while (response != 'O' && response != 'N') {
				System.out.println("Mbola hanohy ve?");
				response = sc.nextLine().charAt(0);
		 }
	  }
  }
  
}
