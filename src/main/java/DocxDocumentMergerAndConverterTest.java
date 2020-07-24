/**
 * 
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
 
 
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
 
/**
 * @author Dhananjay Jha
 *
 */
public class DocxDocumentMergerAndConverterTest {
 
	
	public static void main (String[] args) throws IOException, XDocReportException {
		
		testMergeAndGenerateOutput();
		
	}
 
	/**
	 * Test method for {@link com.sambhashanam.docx.DocxDocumentMergerAndConverter#mergeAndGenerateOutput(java.lang.String, fr.opensagres.xdocreport.template.TemplateEngineKind, java.util.Map, java.util.Map)}.
	 * @throws XDocReportException 
	 * @throws IOException 
	 */
	public static void testMergeAndGenerateOutput() throws IOException, XDocReportException {
 
		String templatePath = "F:\\Velocity\\ThankYouNote_Template.docx";
 
		Map<String, Object> nonImageVariableMap = new HashMap<String, Object>();
		nonImageVariableMap.put("jour", LocalDate.now().getDayOfMonth());
		nonImageVariableMap.put("mois", LocalDate.now().getMonthValue());
		nonImageVariableMap.put("ans", LocalDate.now().getYear());
		
		nonImageVariableMap.put("name", "Rajani Jha dzakmkgenzkmgn amkebgl");
		nonImageVariableMap.put("website", "www.sambhashanam.com");
		nonImageVariableMap.put("author_name", "Dhananjay Jha");
		Map<String, String> imageVariablesWithPathMap =new HashMap<String, String>();
		imageVariablesWithPathMap.put("header_image_logo", "F:\\Velocity\\image.jpg");
 
		DocxDocumentMergerAndConverter docxDocumentMergerAndConverter = new DocxDocumentMergerAndConverter();
		byte[] mergedOutput = docxDocumentMergerAndConverter.mergeAndGenerateOutput(templatePath, TemplateEngineKind.Freemarker, nonImageVariableMap, imageVariablesWithPathMap);
		//assertNotNull(mergedOutput);
		FileOutputStream os = new FileOutputStream("F:\\Velocity\\Resultat\\ThankYouNote"+System.nanoTime()+".docx");
		os.write(mergedOutput);
		os.flush();
		os.close();
 
	}
 
}