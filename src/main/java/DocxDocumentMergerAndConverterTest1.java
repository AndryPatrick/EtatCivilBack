 
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hdf.extractor.WordDocument;
import org.docx4j.openpackaging.exceptions.Docx4JException;

import com.person.utils.DatyAntsoratra;
import com.person.utils.IsaAntsoratra;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
 
/**
 * @author Dhananjay Jha
 *
 */
public class DocxDocumentMergerAndConverterTest1 {
 
 
	public static void main (String[] args) throws IOException, XDocReportException, Docx4JException {
		
		testMergeAndGenerateOutput();
		
	}
	
	
	/**
	 * Test method for {@link com.sambhashanam.docx.DocxDocumentMergerAndConverter#mergeAndGenerateOutput(java.lang.String, fr.opensagres.xdocreport.template.TemplateEngineKind, java.util.Map, java.util.Map)}.
	 * @throws XDocReportException 
	 * @throws IOException 
	 * @throws Docx4JException 
	 */
	public static void testMergeAndGenerateOutput() throws IOException, XDocReportException, Docx4JException {
		String name = "ANDRIAMAHERIMANANA";
		String prenom = "Patrick";
		String lieu = "Mandrosonoro";
		String nomMere = "RASOANALIMANANA";
		String prenomMere = "Rollande";
		int anneeDeclaration = 1994;
		int jour = 12; int mois = 1; int ans = 1994;
		String templatePath = "F:\\Velocity\\ThankYouNote_Template.docx";
		//String templatePath = "F:\\Velocity\\copie.docx";
 
		Map<String, Object> nonImageVariableMap = new HashMap<String, Object>();
		nonImageVariableMap.put("lieu", lieu);
		nonImageVariableMap.put("prenom", prenom);
		
		IsaAntsoratra isa = new IsaAntsoratra();
		DatyAntsoratra daty = new DatyAntsoratra();
		
		nonImageVariableMap.put("nom", name);
		nonImageVariableMap.put("nomMere",nomMere);
		nonImageVariableMap.put("prenomMere",prenomMere);
		nonImageVariableMap.put("anneeDeclaration",isa.conversion(anneeDeclaration));
		nonImageVariableMap.put("naissance", daty.conversion(ans, mois, jour));
		Map<String, String> imageVariablesWithPathMap =new HashMap<String, String>();
		
						
		DocxDocumentMergerAndConverter1 docxDocumentMergerAndConverter = new DocxDocumentMergerAndConverter1();
		byte[] mergedOutput = docxDocumentMergerAndConverter.mergeAndGeneratePDFOutput(templatePath, TemplateEngineKind.Freemarker, nonImageVariableMap, imageVariablesWithPathMap);
		//assertNotNull(mergedOutput);
		//FileOutputStream os = new FileOutputStream("F:\\Velocity\\Resultat\\ThankYouNote"+System.nanoTime()+".pdf");
		FileOutputStream os = new FileOutputStream("F:\\Velocity\\Resultat\\copie"+prenom+System.nanoTime()+".pdf");
		os.write(mergedOutput);
		os.flush();
		os.close();
 
	}
 
}