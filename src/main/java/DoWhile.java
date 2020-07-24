import java.util.Scanner;

public class DoWhile {

	static Scanner sc = new Scanner(System.in);
	static String lieu = new String();
	static String sexe = new String();
	static char reponse = ' ';
	
	public static void main (String[] args) {
		do {
			System.out.println("Aiza ny toerana misy anao:");
			lieu = sc.nextLine();
			
			System.out.println("Lahy sa vavy");
			sexe = sc.nextLine();
			int codeLieu = 0;
			int codeSexe = 0;
			int valeur = 26159;
			valeur +=1;
			
			switch(lieu) {
				case "Ambositra":
					codeLieu = 203;
						if (sexe.equals("lahy")) {
							codeSexe = 1;
							System.out.println("numéro cin: "+codeLieu+"01"+codeSexe+"0"+valeur);
						}
						else {
							codeSexe = 2;
							System.out.println("numéro cin: "+codeLieu+"01"+codeSexe+"0"+valeur);
						}
					break;
					
				case "Ambatofinandrahana":
					codeLieu = 201;
						if (sexe.equals("lahy")) {
							codeSexe = 1;
							System.out.println("numéro cin: "+codeLieu+"01"+codeSexe+"0"+valeur);
						}
						else {
							codeSexe = 2;
							System.out.println("numéro cin: "+codeLieu+"01"+codeSexe+"0"+valeur);
						}
					break;
			}
			
			do {
				System.out.println(" mbola hanohy ve ?");
				reponse = sc.nextLine().toUpperCase().charAt(0);
			}while (reponse != 'O' && reponse != 'N');
			
			
		}while (reponse == 'O');
	
		System.out.println("veloma tompoko");
	}
}
