package com.person.utils;

import org.springframework.beans.factory.annotation.Autowired;

import com.person.Data.DAO.LocalisationDAO;
import com.person.Data.DAO.PersonDAO;
import com.person.service.ServicePerson;



public class FormatCIN {
	static
	PersonDAO personDAO;
	
	@Autowired
	LocalisationDAO localisationDAO;
	
	@Autowired
	ServicePerson servicePerson;
	
	String resultat;
	Long cin;
	Long test;
	
	public String ajoutEspace(String valeur) {
		int a = 0;
		int b =3 ;
		String cin = null;
		
		
		if (valeur.equals("null")) {
			cin = null;
		}
		else if (valeur.length() < 15 && !valeur.equals("null")) {
			cin = valeur.substring(a, b)+" "+valeur.substring(a+3, b+3)+" "+valeur.substring(a+6, b+6)+" "+
					valeur.substring(a+9, b+9);
		}
		else {
			cin = valeur.substring(a, b)+" "+valeur.substring(a+3, b+3)+" "+valeur.substring(a+6, b+6)+" "+
					valeur.substring(a+9, b+9)+" "+valeur.substring(a+12, b+12);
		}
		
		resultat = cin;
		
		return resultat;
	}
	
	public String supprimerEspace (String valeur) {
		
		String a = valeur.replaceAll(" ","");
		
		resultat = a;
		
		return resultat;
	}
	
	public String recupererLettre(String valeur) {
		
		int a = valeur.length();
		
		String recuperDeuxDernierLettre = valeur.substring(a-2, a);
		
		resultat = recuperDeuxDernierLettre;
		
		return resultat;
	}
	
	/*
	 * public Long genererCIN(String lieu,char sexe, Long lastIdentityNumber) {
		int codeLieu, codeSexe;
		String identity = String.valueOf(lastIdentityNumber);
		String identity1 = identity.substring(7, 12);
		int valeur = Integer.valueOf(identity1).intValue();
		valeur += 1;
		
		//Long value = 
		switch (lieu) {
		case "Ambositra":
			codeLieu = 203;
			if (sexe == 'H') {
				codeSexe = 1;
				resultat = codeLieu+"01"+codeSexe+"0"+valeur;
				cin = Long.valueOf(resultat).longValue();
			}
			else {
				codeSexe = 2;
				resultat = codeLieu+"01"+codeSexe+"0"+valeur;
				cin = Long.valueOf(resultat).longValue();
			}

			break;

		case "Antananarivo":
			codeLieu = 201;
			if (sexe == 'H') {
				codeSexe = 1;
				resultat =codeLieu+"01"+codeSexe+"0"+valeur;
				cin = Long.valueOf(resultat).longValue();
			}
			else {
				codeSexe = 2;
				resultat = codeLieu+"01"+codeSexe+"0"+valeur;
				cin = Long.valueOf(resultat).longValue();
			}
			
			break;

		default:
			resultat = "Tsy mamoaka karatra io faritra misy anao io";
			break;
			
			
		}
		return cin ;
	}

	 */
	
	public Long genererCIN(Integer codeLieu,String lieu,boolean sexe, Long lastIdentityNumber) {
		String codeSexe = null;
		Long valeur= 0L;
		if (lastIdentityNumber == 0 ) {
			if (sexe == true ) {
				codeSexe = "1";
				resultat = codeLieu+""+codeSexe+"1";
				cin = Long.valueOf(resultat).longValue();
			}
			else if (sexe == false){
				codeSexe = "2";
				resultat = codeLieu+""+codeSexe+"1";
				cin = Long.valueOf(resultat).longValue();
			}
		} 
		else if (lastIdentityNumber != 0 ){
		//String identity = String.valueOf(lastIdentityNumber);
		//String identity1 = identity.substring(7, 12);
		 valeur = lastIdentityNumber + 1;
		//valeur += 1;
		
			if (sexe == true) {
				codeSexe = "1";
				resultat = codeLieu+""+codeSexe+""+valeur;
				cin = Long.valueOf(resultat).longValue();
			}
			else if (sexe == false) {
				codeSexe = "2";
				resultat = codeLieu+""+codeSexe+""+valeur;
				cin = Long.valueOf(resultat).longValue();
			}
	    }
		
		if (String.valueOf(cin).length() < 12) {
			String a = "0";
			String value =String.valueOf(cin);
			int longueur = value.length();
			String val = value.substring(7,longueur);
			do {
				val = a+val;
				resultat = codeLieu+codeSexe+val;
				cin = Long.valueOf(resultat).longValue();
				
			}while (String.valueOf(cin).length() < 12);
		}
			
		return cin ;
	}
	
	public Long genererCIN(Integer codeLieu,boolean sexe, Long lastIdentityNumber) {
		String codeSexe = null;
		Long valeur= 0L;
		if (lastIdentityNumber == null) {
			if (sexe == true ) {
				codeSexe = "1";
				resultat = codeLieu+""+codeSexe+"1";
				cin = Long.valueOf(resultat).longValue();
			}
			else if (sexe == false){
				codeSexe = "2";
				resultat = codeLieu+""+codeSexe+"1";
				cin = Long.valueOf(resultat).longValue();
			}
		} 
		else if (lastIdentityNumber != 0 ){
		//String identity = String.valueOf(lastIdentityNumber);
		//String identity1 = identity.substring(7, 12);
		 valeur = lastIdentityNumber + 1;
		//valeur += 1;
		
			if (sexe == true) {
				codeSexe = "1";
				resultat = codeLieu+""+codeSexe+""+valeur;
				cin = Long.valueOf(resultat).longValue();
			}
			else if (sexe == false) {
				codeSexe = "2";
				resultat = codeLieu+""+codeSexe+""+valeur;
				cin = Long.valueOf(resultat).longValue();
			}
	    }
		
		if (String.valueOf(cin).length() < 12) {
			String a = "0";
			String value =String.valueOf(cin);
			int longueur = value.length();
			String val = value.substring(7,longueur);
			do {
				val = a+val;
				resultat = codeLieu+codeSexe+val;
				cin = Long.valueOf(resultat).longValue();
				
			}while (String.valueOf(cin).length() < 12);
		}
			
		return cin ;
	}
	
	public String detailSexe(boolean sexe) {
		String result = null;	
			if (sexe == true) {
				result ="masculin";
			}
			else if (sexe == false) {
				result = "féminin";
			}
			else {
				result = null;
			}
			
		return result;
	}
	
	public String detailSituation(boolean situation) {
		String result = null;
			if (situation == true) 
				result = "marié";
			else if (situation == false)
				result = "célibataire";
			else 
				result = null;
		return result;
	}
	
}
