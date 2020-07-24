import java.util.Scanner;

public class TestCIN {

	public static void main(String[] args) {
		System.out.println("Apidiro ny toerana misy anao");
			Scanner sc = new Scanner(System.in);
			String cin = sc.nextLine();
			
			char code1 = cin.charAt(0);
			char code2 = cin.charAt(1);
			char code3 = cin.charAt(2);
			char code4 = cin.charAt(3);
			char code5 = cin.charAt(4);
			char code6 = cin.charAt(5);
			
			//Convertion en String
			String valeur1 = new String();
			
			/*valeur1 = valeur1.valueOf(code1);
			String valeur2 = valeur1.valueOf(code2);
			String valeur3 = valeur1.valueOf(code3);
			System.out.println("code postal "+val);
			System.out.println("code commune "+codeCommune);
			System.out.println("sexe "+sexePers); 
			//String code = valeur1+valeur2+valeur3;
			
			String sexe = valeur1.valueOf(code6);
			
			String val = valeur1.valueOf(code1)+valeur1.valueOf(code2)+valeur1.valueOf(code3);
			
			int codeCommune = Integer.valueOf(val).intValue();
			int sexePers = Integer.valueOf(sexe).intValue(); */
			
			if (cin=="Ambositra") {
				int code = 203;
				System.out.println(code);
			}
			
		/*
		 * if (sexePers == 1 && codeCommune == 203) {
		 * System.out.println("Ianao dia lehilahy teraka tao Ambositra"); } else if
		 * (sexePers == 2 && codeCommune == 203) {
		 * System.out.println("Ianao dia vehivavy teraka tao Ambositra"); } else if
		 * (sexePers == 1 && codeCommune == 101) {
		 * System.out.println("Ianao dia lehilahy teraka tao Antananarivo"); } else if
		 * (sexePers == 2 && codeCommune == 101) {
		 * System.out.println("Ianao dia vehivavy teraka tao Antananarivo"); } else if
		 * (sexePers == 1 && codeCommune == 301) {
		 * System.out.println("Ianao dia lehilahy teraka tao Fianarantsoa"); } else if
		 * (sexePers == 2 && codeCommune == 301) {
		 * System.out.println("Ianao dia vehivavy teraka tao Fianarantsoa"); }
		 */

	}

}
