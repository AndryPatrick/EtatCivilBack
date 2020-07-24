package com.person.utils;

public class DatyAntsoratra {

	String resultat;
	String valeur;
	
	public String moisEnLettre (int mois) {
		
		switch (mois) {
			case 1:
				valeur = "janohary";
				resultat = valeur;
			break;
			
			case 2:
				valeur = "febroary";
				resultat = valeur;
			break;
			
			case 3:
				valeur = "martsa";
				resultat = valeur;
			break;
			
			case 4:
				valeur = "aprily";
				resultat = valeur;
			break;
			
			case 5:
				valeur = "mai";
				resultat = valeur;
			break;
			
			case 6:
				valeur = "jiona";
				resultat = valeur;
			break;
			
			case 7:
				valeur = "jolay";
				resultat = valeur;
			break;
			
			case 8:
				valeur = "aogositra";
				resultat = valeur;
			break;
			
			case 9:
				valeur = "septambra";
				resultat = valeur;
			break;
			
			case 10:
				valeur = "oktobra";
				resultat = valeur;
			break;
			
			case 11:
				valeur = "novambra";
				resultat = valeur;
			break;
			
			case 12:
				valeur = "desambra";
				resultat = valeur;
			break;

		default:
			break;
		}
		
		return resultat;
	}
	
	public String conversionDate(String date) {
		char marque = date.charAt(4);
		String oraAntsoratra;
		String minitraAntsoratra;
		String segondraAntsoratra;
		
		
		if (marque == '-') {
			
			if (date.length() == 10) {
				String taona = date.substring(0, 4);
				String volana = date.substring(5, 7);
				String andro = date.substring(8, 10);
				IsaAntsoratra isa = new IsaAntsoratra();
				
				int taonaEntier = Integer.valueOf(taona).intValue();
				int androEntier = Integer.valueOf(andro).intValue();
				int volanaEntier = Integer.valueOf(volana).intValue();
				
				String volanaAntsoratra = moisEnLettre(volanaEntier);
				String taonaAntsoratra = isa.conversion(taonaEntier);
				String androAntsoratra = isa.conversion(androEntier);
				
				resultat = androAntsoratra+" "+volanaAntsoratra+" taona "+taonaAntsoratra;
			}
			else {
				String taona = date.substring(0, 4);
				String volana = date.substring(5, 7);
				String andro = date.substring(8, 10);
				
				String ora = date.substring(11, 13);
				String minitra = date.substring(14, 16);
				String segondra = date.substring(17, 19);
				
				IsaAntsoratra isa = new IsaAntsoratra();
				
				int taonaEntier = Integer.valueOf(taona).intValue();
				int androEntier = Integer.valueOf(andro).intValue();
				int volanaEntier = Integer.valueOf(volana).intValue();
				int oraEntier = Integer.valueOf(ora).intValue();
				int minitraEntier = Integer.valueOf(minitra).intValue();
				int segondraEntier = Integer.valueOf(segondra).intValue();	
				
				String volanaAntsoratra = moisEnLettre(volanaEntier);
				String taonaAntsoratra = isa.conversion(taonaEntier);
				String androAntsoratra = isa.conversion(androEntier);
				
				oraAntsoratra = isa.conversion(oraEntier) +" ora sy ";
				minitraAntsoratra = isa.conversion(minitraEntier)+" minitra sy ";
				segondraAntsoratra = isa.conversion(segondraEntier)+ " segondra";
				
				
				
				if (0<oraEntier && oraEntier <13 ) {
				
					resultat = androAntsoratra+" "+volanaAntsoratra+" taona "+taonaAntsoratra+ ", tamin'ny "+oraAntsoratra+minitraAntsoratra+segondraAntsoratra+" maraina " ;
				
				}
				else if (13<= oraEntier && oraEntier <18 ) {
					oraAntsoratra = isa.conversion(oraEntier - 12) +" ora sy ";
					
					resultat = androAntsoratra+" "+volanaAntsoratra+" taona "+taonaAntsoratra+ ", tamin'ny "+oraAntsoratra+minitraAntsoratra+segondraAntsoratra+" tolakandro " ;
					
				}
				else {
					oraAntsoratra = isa.conversion(oraEntier - 12) +" ora sy ";
					resultat = androAntsoratra+" "+volanaAntsoratra+" taona "+taonaAntsoratra+ ", tamin'ny "+oraAntsoratra+minitraAntsoratra+segondraAntsoratra+" alina " ;
					
				}
				
			}
			
		} else {
			String taona = date.substring(6, 10);
			String volana = date.substring(3, 5);
			String andro = date.substring(0, 2);
			IsaAntsoratra isa = new IsaAntsoratra();
			
			int taonaEntier = Integer.valueOf(taona).intValue();
			int androEntier = Integer.valueOf(andro).intValue();
			int volanaEntier = Integer.valueOf(volana).intValue();
			
			String volanaAntsoratra = moisEnLettre(volanaEntier);
			String taonaAntsoratra = isa.conversion(taonaEntier);
			String androAntsoratra = isa.conversion(androEntier);
			 
			resultat = "teraka tamin'ny "+androAntsoratra+" "+volanaAntsoratra+" taona "+taonaAntsoratra;
		}
		return resultat;
	}
	
	public String conversion(int ans, int mois, int jour) {
		IsaAntsoratra isa = new IsaAntsoratra();
		String taona  = isa.conversion(ans);
		String volana  = moisEnLettre(mois);
		String andro = isa.conversion(jour);
		
		resultat = andro+" "+volana+" "+taona;
		return resultat;
	}
	
	
}
