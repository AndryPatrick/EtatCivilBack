package com.person.utils;

public class IsaAntsoratra {

	String resultat;
	String valeur;
	String a, b,c,d;
	
	//valeur de base
	public String base (int chiffre) {
			switch (chiffre) {
				case 0:
					valeur ="";
					resultat = valeur;
				break;
				
				case 1:
					valeur ="iray";
					resultat = valeur;
				break;
					
				case 2:
						valeur ="roa";
						resultat = valeur;
					break;
					
				case 3:
					valeur ="telo";
					resultat = valeur;
				break;
				
				case 4:
					valeur ="efatra";
					resultat = valeur;
				break;
				
				case 5:
					valeur ="dimy";
					resultat = valeur;
				break;
				
				case 6:
					valeur ="enina";
					resultat = valeur;
				break;
				
				case 7:
					valeur ="fito";
					resultat = valeur;
				break;
				
				case 8:
					valeur ="valo";
					resultat = valeur;
				break;
				
				case 9:
					valeur ="sivy";
					resultat = valeur ;
				break;
				
				case 10:
					valeur ="folo";
					resultat = valeur;
				break;
					
				case 20:
						valeur ="roapolo";
						resultat = valeur;
					break;
					
				case 30:
					valeur ="telopolo";
					resultat = valeur;
				break;
				
				case 40:
					valeur ="efapolo";
					resultat = valeur;
				break;
				
				case 50:
					valeur ="dimapolo";
					resultat = valeur;
				break;
				
				case 60:
					valeur ="enimpolo";
					resultat = valeur;
				break;
				
				case 70:
					valeur ="fitopolo";
					resultat = valeur;
				break;
				
				case 80:
					valeur ="valopolo";
					resultat = valeur;
				break;
				
				case 90:
					valeur ="sivifolo";
					resultat = valeur ;
				break;
				
				case 100:
					valeur ="zato";
					resultat = valeur;
				break;
				
				case 200:
					valeur ="roanjato";
					resultat = valeur;
				break;
					
				case 300:
						valeur ="telonjato";
						resultat = valeur;
					break;
					
				case 400:
					valeur ="efajato";
					resultat = valeur;
				break;
				
				case 500:
					valeur ="dimanjato";
					resultat = valeur;
				break;
				
				case 600:
					valeur ="eninjato";
					resultat = valeur;
				break;
				
				case 700:
					valeur ="fitonjato";
					resultat = valeur;
				break;
				
				case 800:
					valeur ="valonjat";
					resultat = valeur;
				break;
				
				case 900:
					valeur ="sivanjato";
					resultat = valeur;
				break;
				
				case 1000:
					valeur ="arivo";
					resultat = valeur ;
				break;
				
			default:
				resultat = "Tsy anaty lisitra ny tarehimarika napidirinao";
				break;
		}
			
		return resultat;
	}
	
	//valeur pour le dizaine
	public String dizaineChiffreEnLettre (int chiffre) {
		a = String.valueOf(chiffre);
		b= a.substring(1);
		int entierB = Integer.valueOf(b).intValue();
		int entierC = chiffre - entierB;
		
		if (a.charAt(1)=='0') {
			resultat = base(chiffre);
		}
		else if ( entierB == 0) {
			resultat = base(entierC);
		}
		else if (entierB == 1) {
			resultat="iraika amby "+ base(entierC)  ;
		}else {
			resultat= base(entierB)+ " amby "+ base(entierC)  ;
		}
			
		return resultat;
	}
	
	//valeur pour le centaine
	public String centaineChiffreEnLettre (int chiffre) {
		a = String.valueOf(chiffre);
		b = a.substring(1, 3);
		char d = a.charAt(1);
		c = String.valueOf(d);
		
		int entierB = Integer.valueOf(b).intValue();
		int entierD = Integer.valueOf(c).intValue();
		int entierE = chiffre - entierB; 
		
		if (b.equals("00")) {
			
			resultat = base(chiffre);			
		}
		else if (entierD == 0 &&  entierE == 100) {
			 
			if (entierB == 1) {
				resultat ="iraika amby "+base(entierE);
			}else {
				resultat = base(entierB)+" amby "+base(entierE);
			}
				
		}
		else if (entierD == 0 &&  entierE != 100) {
			
			if (entierB == 1) {
				resultat = "iraika sy "+base(entierE);
			}else {
				resultat = base(entierB)+" sy "+base(entierE);
			}
				
		}
		else if (entierE == 100) {
			
			resultat = dizaineChiffreEnLettre(entierB)+" amby "+base(entierE);
		}
		else {
			
			resultat = dizaineChiffreEnLettre(entierB)+" sy "+base(entierE);
		}
		
		return resultat;
	}
	
	
	//valeur pour le mille
	public String milleChiffreEnLettre (int chiffre) {
		String chiffre1 = String.valueOf(chiffre);
		a = String.valueOf(chiffre);
		b = a.substring(1, 4);
		char c = a.charAt(0);
		String d = String.valueOf(c);
		String e = a.substring(1, 3);
		
		//4eme caract�re
		char f = a.charAt(3);
		String g = String.valueOf(f);
		
		//2eme caractere
		char h = a.charAt(1);
		String i = String.valueOf(h);
		
		//3eme et 4eme caract�re
		String j = a.substring(2, 4);
		
		//3 dernier caract�re
		String k = a.substring(1, 4);
		
		int entierB = Integer.valueOf(b).intValue();
		int entierD = Integer.valueOf(d).intValue();
		int entierF = Integer.valueOf(g).intValue();
		int entierH = Integer.valueOf(i).intValue();
		int entierJ = Integer.valueOf(j).intValue();
		int entierK = Integer.valueOf(k).intValue();
		
		//valeur 1000 - dizaine
		int entierMille = chiffre - entierJ;
		
		//valeur mille - centaine
		int entierMille1 = chiffre - entierK;
		
		
		if (b.equals("000")) {
			if (entierD == 1) {
				resultat = "arivo";
			}
			else if (entierD != 1) {
				resultat = base(entierD)+" arivo";
			}
		}
		else if (e.equals("00")) {
			if (entierD == 1) {
				resultat = base(entierF)+" sy arivo";
			}
			else if (entierD != 1) {
				resultat = base(entierF)+" sy "+base(entierD)+" arivo";
			}
		}
		else if (i.equals("0")) {
			if (entierD == 1) {
				resultat = dizaineChiffreEnLettre(entierJ)+" sy arivo";
			}
			else if (entierD != 1) {
				resultat = dizaineChiffreEnLettre(entierJ)+" sy "+base(entierD)+" arivo";
			}
		}else {
			if (entierD == 1) {
				resultat = centaineChiffreEnLettre(entierK)+" sy arivo";
			}
			else if (entierD != 1) {
				resultat = centaineChiffreEnLettre(entierK)+" sy "+base(entierD)+" arivo";
			}
		}
		
		
		return resultat;
	}
	
	//conversion en lettre dans les diff�rentes conditions
	public String conversion (int chiffre1) {
		
		String chiffre = String.valueOf(chiffre1);
		
		if  ( chiffre.length() == 1 ) {
			
			resultat = base(chiffre1);
			
		}
		else  if (chiffre.length() == 2) {
			
			resultat = dizaineChiffreEnLettre(chiffre1);
			
		}
		else if (chiffre.length() == 3) {
				
				resultat = centaineChiffreEnLettre(chiffre1);
						
		}
		else if (chiffre.length() == 4) {
			
			resultat = milleChiffreEnLettre(chiffre1);
			
		}
		return resultat;
	}
}
