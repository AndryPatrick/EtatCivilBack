import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		String nom ="ANTANAMAHALANA";
		
		char a = nom.charAt(0);
		String b = (nom.substring(1, nom.length())).toLowerCase();
		
		String resultat = a+b;
		System.out.println(resultat);
	}

}
