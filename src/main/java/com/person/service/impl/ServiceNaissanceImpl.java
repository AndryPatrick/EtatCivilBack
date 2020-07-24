package com.person.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.Data.DAO.LocalisationDAO;
import com.person.Data.DAO.NaissanceDAO;
import com.person.entity.Commune;
import com.person.entity.Mairie;
import com.person.repository.NaissanceRepository;
import com.person.service.ServiceNaissance;
import com.person.service.bean.Naissance;
import com.person.utils.DatyAntsoratra;
import com.person.utils.FormatCIN;
import com.person.utils.GenerationPDF;
import com.person.utils.IsaAntsoratra;
import com.person.utils.LieuHelpers;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

@Service
public class ServiceNaissanceImpl implements ServiceNaissance{
	
	@Autowired
	NaissanceRepository naissanceRepository;
	
	@Autowired
	LocalisationDAO localisationDAO;
	
	@Autowired
	NaissanceDAO naissanceDAO;
	
	@Override
	public String addNaissance(Naissance naissance) {
		FormatCIN format = new FormatCIN();
		com.person.entity.Naissance naissanceEntity = new com.person.entity.Naissance();
			naissanceEntity.setName(naissance.getName());
			naissanceEntity.setFamilyName(naissance.getFamilyName());
			naissanceEntity.setDateOfBirth(LocalDateTime.now());
			Optional<Commune> communeOpt = this.localisationDAO.findCommuneById(naissance.getPlaceOfBirth());
			
			naissanceEntity.setPlaceOfBirth(communeOpt.get()); 
			naissanceEntity.setFatherName(naissance.getFatherName());
			naissanceEntity.setMotherName(naissance.getMotherName());
			naissanceEntity.setSexe(naissance.isSexe());
			
			Long lastIdentityNumber = naissanceDAO.getLastIdentity(communeOpt.get().getId());
			
			naissanceEntity.setIdentity(format.genererCIN(communeOpt.get().getCode(), naissance.isSexe(), lastIdentityNumber));
			naissanceEntity.setAnsMere(naissance.getAnsMere());
			
			Optional<Commune> communeNaissOpt = this.localisationDAO.findCommuneById(naissance.getPlaceOfBirthMother());
			naissanceEntity.setPlaceOfBirthMother(communeNaissOpt.get());
			naissanceEntity.setProfessionMere(naissance.getProfessionMere());
			naissanceEntity.setLieuResidenceMere(naissance.getLieuResidenceMere());
			naissanceEntity.setDateCopie(naissance.getDateCopie());
			naissanceEntity.setNomInfirmiere(naissance.getNomInfirmiere());
			naissanceEntity.setYearNaissInfirmiere(naissance.getYearNaissInfirmiere());
			naissanceEntity.setProfessionInfirmiere(naissance.getProfessionInfirmiere());
			naissanceEntity.setLieuResidenceInfirmiere(naissance.getLieuResidenceInfirmiere());
			this.naissanceRepository.save(naissanceEntity);
		return 	"valeur ajouter avec succès";
	}

	@Override
	public Naissance genererCopie(long identity) throws IOException, XDocReportException, Docx4JException {
		//List<com.person.entity.Naissance> naissanceList = this.naissanceDAO.getNaissanceById(identity);
		
		DatyAntsoratra daty = new DatyAntsoratra();
		IsaAntsoratra isa = new IsaAntsoratra();
		LieuHelpers lieuHelpers = new LieuHelpers();
		com.person.entity.Naissance naissanceEntity = this.naissanceDAO.getNaissanceById(identity);
		Mairie maire = this.naissanceDAO.getMaire(naissanceEntity.getPlaceOfBirth().getId());
		int ansDeclaration = this.naissanceDAO.getYear(identity);
		int mois = this.naissanceDAO.getMois(identity);
		int jour = this.naissanceDAO.getDays(identity);
		int jourDeclaration = this.naissanceDAO.getDaysDeclaration(identity);
		
		
		String templatePath = "src/main/resources/templates/copieNaissance.docx";
		Map<String, Object> naissanceValue = new HashMap<String, Object>();
		naissanceValue.put("nom", naissanceEntity.getName());
		naissanceValue.put("prenom", naissanceEntity.getFamilyName());
		naissanceValue.put("lieu", lieuHelpers.conversionLieu(naissanceEntity.getPlaceOfBirth().getNameCommune()));
		String naissance = String.valueOf(naissanceEntity.getDateOfBirth());
		naissanceValue.put("naissanceStr", daty.conversionDate(naissance));
		naissanceValue.put("naissance", jour+" "+daty.moisEnLettre(mois)+" "+ansDeclaration);
		naissanceValue.put("declaration", jourDeclaration+" "+daty.moisEnLettre(mois)+" "+ansDeclaration);
		int ans = LocalDateTime.now().getYear();
		
		naissanceValue.put("anneeDeclaration", isa.conversion(ansDeclaration));
		naissanceValue.put("dateActuel", daty.conversionDate(String.valueOf(LocalDate.now())));
		naissanceValue.put("commune", lieuHelpers.conversionLieu(naissanceEntity.getPlaceOfBirth().getNameCommune()));
		naissanceValue.put("district", lieuHelpers.conversionLieu(naissanceEntity.getPlaceOfBirth().getDistrict().getNameDistrict()));
		naissanceValue.put("mere", naissanceEntity.getMotherName());
		naissanceValue.put("sexe", getSexe(naissanceEntity.isSexe()));
		naissanceValue.put("ansMere", isa.conversion(naissanceEntity.getAnsMere()));
		naissanceValue.put("lieuNaissanceMere", lieuHelpers.conversionLieu(naissanceEntity.getPlaceOfBirthMother().getNameCommune()));
		naissanceValue.put("professionMere", naissanceEntity.getProfessionMere());
		naissanceValue.put("addresseMere", naissanceEntity.getLieuResidenceMere());
		naissanceValue.put("dateCopie", daty.conversionDate(String.valueOf(naissanceEntity.getDateCopie())));
		naissanceValue.put("nomInfirmiere", naissanceEntity.getNomInfirmiere());
		naissanceValue.put("anneeNaissanceInfirmiere", isa.conversion(naissanceEntity.getYearNaissInfirmiere()));
		naissanceValue.put("lieuNaissanceInfirmiere", naissanceEntity.getLieuResidenceInfirmiere());
		naissanceValue.put("professionInfirmiere", naissanceEntity.getProfessionInfirmiere());
		naissanceValue.put("addresseInfirmiere", naissanceEntity.getLieuResidenceInfirmiere());
		naissanceValue.put("maire", maire.getNomMaire()+" "+maire.getPrenomMaire());
		naissanceValue.put("communeDirige", lieuHelpers.conversionLieu(maire.getCommune().getNameCommune()));
		naissanceValue.put("numCopi", 434);
		
		Map<String, String> image =new HashMap<String, String>();
		
		GenerationPDF generer = new GenerationPDF();
		
		byte[] mergedOutput = generer.mergeAndGeneratePDFOutput(templatePath, TemplateEngineKind.Freemarker, naissanceValue, image);
		FileOutputStream os = new FileOutputStream("F:\\Velocity\\Resultat\\copie"+naissanceEntity.getFamilyName()+System.nanoTime()+".pdf");
		os.write(mergedOutput);
		os.flush();
		os.close();
		//rasoarollande@gmail.com
		return null;
	}

	private String getSexe (boolean sexe) {
		String valeur = null;
		
		if (sexe ==true) {
			valeur = "zazalahy";
		}
		else {
			valeur ="zazavavy";
		}
		
		return valeur;
	}
	
}
